package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * This class is in charge of controlling the functions of each class called
 * from the administration class
 */
public class Controller {

    private final int SIZE = 10;
    private ProjectSQA[] projectSQA = new ProjectSQA[SIZE];
    private ProjectSQA currentProject;
    private int amoProject = 0;
    private SimpleDateFormat view = new SimpleDateFormat("dd/MM/yyyy 'hours: ' hh:mm:ss a");
    private String url[] = new String[3000];// The var url have a size of 3000 by: 10(Project)*6(stage)*50(capsules)
    private int accountUrl = 0;

    public Controller() {
    }

    /**
     * In charge of registering a project and storing it in an arrangement of this
     * type
     * 
     * @param name
     * @param startDate
     * @param budget
     * @return a String if registered or can no longer be registered
     */
    public boolean registerProject(String name, Calendar startDate, double budget) {

        boolean register = false;

        if (amoProject != projectSQA.length) {
            projectSQA[amoProject] = new ProjectSQA(name, startDate, budget);
            register = true;
            currentProject = projectSQA[amoProject];
            amoProject++;
        }
        return register;
    }

    public boolean verifyNoRepeatProyect(String name) {
        boolean isFound = false;

        for (int i = 0; i < amoProject && !isFound; i++) {
            if (projectSQA[i].getName().equalsIgnoreCase(name)) {
                isFound = true;
            }
        }
        return isFound;

    }

    /**
     * Register the client or manager in a project
     * 
     * @param name
     * @param phone
     * @param typePerson
     * @return
     */
    public String registerPerson(String name, String phone, String typePerson) {
        return currentProject.registerPerson(name, phone, typePerson);
    }

    /**
     * Assigns the dates of the projects, according to the number of months
     * registered, and with a method of the same name assigns the final and initial
     * dates of this
     * 
     * @param month
     * @return a message if the dates were correctly assigned
     */

    public String assingDate(int[] month) {
        return currentProject.assingDate(month);
    }

    /**
     * This method is in charge of searching for a project with the entered name, if
     * it finds it, it will store it in the currentProject object, this has the
     * objective of making two objects with mutual modification from one
     * 
     * @param name name of the project to search for
     * @return true: found, false: not found
     */
    public boolean searchProjectSQA(String name) {
        boolean isFound = false;

        for (int i = 0; i < amoProject && !isFound; i++) {
            if (name.equalsIgnoreCase(projectSQA[i].getName())) {
                isFound = true;
                currentProject = projectSQA[i];
            }
        }
        return isFound;
    }

    /**
     * Registers the capsules in a specific stage of a project
     * 
     * @param id
     * @param description
     * @param type
     * @param nameCollaborator
     * @param charge
     * @param learning
     * @return Returns a message if the save was achieved or the space is full
     *         storage
     */
    public String addCapsule(String id, String description, int type, String nameCollaborator, String charge,
            String learning, String[] hashtag) {
        String msg = "";
        if (currentProject != null) {

            TypeCapsule typeCapsule = null;
            switch (type) {
                case 1 -> typeCapsule = TypeCapsule.Tecnic;
                case 2 -> typeCapsule = TypeCapsule.Manage;
                case 3 -> typeCapsule = TypeCapsule.Domain;
                case 4 -> typeCapsule = TypeCapsule.Experience;
            }
            Capsule capsule = new Capsule(id, description, typeCapsule, nameCollaborator, charge, learning, hashtag);
            msg = currentProject.getStage(currentProject.counStage()).addCapsule(capsule);
        }
        return msg;
    }

    /**
     * This control method is responsible for verifying that the same ID of a
     * project or with other projects is not repeated, since they are unique
     * @param id Capsule ID
     * 
     * @return If there is True returns, but the opposite
     * 
     */
    public boolean verifyNoRepeatCapsule(String id) {
        boolean repeat = false;

        for (int i = 0; i < amoProject && !repeat; i++) {
            for (int j = 0; j <= projectSQA[i].counStage() && !repeat; j++) {
                for (int j2 = 0; j2 < projectSQA[i].getStage(j).getCapCouter() && !repeat; j2++) {
                    for (int k = 0; k < projectSQA[i].getStage(j).getCapCouter() && !repeat; k++) {
                        if (projectSQA[i].getStage(j).getCapsule(k).getId().equalsIgnoreCase(id)) {
                            repeat = true;

                        }
                    }
                }
            }
        }

        return repeat;
    }

    /**
     * Method to approve the capsules from their id
     * 
     * @param id Capsule ID
     * @return if the capsule exists, it was approved, otherwise
     */
    public String capsuleApproval(String id) {

        String project, stage;
        String capsule = "The calpsule with its " + id + " not exist";
        boolean isFound = false;
        Calendar aprobationDate = Calendar.getInstance();

        for (int i = 0; i < amoProject && !isFound; i++) {
            for (int j = 0; j < 6 && !isFound; j++) {
                if (projectSQA[i] != null) {
                    isFound = projectSQA[i].getStage(j).capsuleApproval(id, aprobationDate);
                    if (isFound) {
                        project = projectSQA[i].getName();
                        stage = projectSQA[i].getStage(i).getType();
                        capsule = "The calpsule " + id + " from " + stage + "'s stage of the" + project
                                + " project was approved. Date: " + view.format(aprobationDate.getTime());
                    }
                }
            }
        }
        return capsule;
    }

    /**
     * Displays the name of a project stage.
     * 
     * @param i Position of a stage within a project.
     * @return The name of the stage being searched for.
     */
    public String stageName(int i) {
        return currentProject.getStage(i).getType();
    }

    /**
     * @return The name of the current project being worked on.
     */
    public String projectName() {
        return currentProject.getName();
    }

    /**
     * @return The position of the current stage being worked on within a project.
     */
    public int counStage() {
        return currentProject.counStage();
    }

    /**
     * Approves a project stage by calling a method of the Project class to approve
     * a stage and saves the real end date of that stage.
     * 
     * @param realEnd The final date on which the stage was completed.
     * @return Whether the stage was approved or if no more stages can be approved.
     */
    public String approbationStage(Calendar realEnd) {

        return currentProject.approbationStage(realEnd);

    }

    /**
     * 
     * This control method is responsible for creating the URL of the capsule that
     * was approved by the user, asking for basic data where the capsule comes.
     * Also the mode of publication of the capsule changes to public (True)
     * 
     * @param project   Project name
     * @param stage     stage name where was the capsule
     * @param posStage  position from stage
     * @param idCapsule
     * @return The URL of the Capsula already approved returns
     */
    public String publishCapsule(String project, String stage, int posStage, String idCapsule) {
        String url = "";
        searchProjectSQA(project);
        currentProject.getStage(posStage).searchCapsule(idCapsule).setPublish(true);
        url = "https://www.capsulas/capsula/" + idCapsule + "/project:" + project + "/stage:" + stage + ".com";
        this.url[accountUrl++] = url;
        return url;
    }

    /**
     * This method is controlled has the function of showing the capsules, and San
     * those that are or not approved with exception to those already
     * published.Therefore, the Sitema recovers an approval parameter if you want to
     * observe the capsules already approved or not.
     * Already found the desired capsule, save the data in a matrix with 100 rows
     * and four columns.Each column of the Matrix will keep data according to its
     * position such as: 0. Project Name, 1. Type of stage, 2. ID of the capsule and
     * 3. Capsula position.
     * The above has two objectives.The first is to show the URL to the user and the
     * second to look for it when it is approved
     * 
     * @param approval True: Show approved capsules to see which one publish, false:
     *                 see capsules that are not approved *
     * @return Matrix with the capsules without approve or to publish
     */

    public String[][] showCapule(boolean aprobation) {
        String msg[][] = new String[100][4];
        int l = 0;
        for (int i = 0; i < amoProject; i++) {// looop of project
            for (int j = 0; j <= projectSQA[i].counStage(); j++) {// loop of stage
                for (int j2 = 0; j2 < 50; j2++) {
                    if (projectSQA[i].getStage(j).getCapsule(j2) != null// ←if there are capsules
                            && projectSQA[i].getStage(j).getCapsule(j2).getAprobation() == aprobation) {
                        // ↑ if the capsule is approved or is not approved

                        if (projectSQA[i].getStage(j).getCapsule(j2).getPublish() == false) {
                            // ↑ if the capsule is not published
                            msg[l][0] = projectSQA[i].getName();
                            msg[l][1] = projectSQA[i].getStage(j).getType();
                            msg[l][2] = projectSQA[i].getStage(j).getCapsule(j2).getId();
                            msg[l][3] = String.valueOf(j);
                            l++;
                        }
                    }
                }
            }
        }
        return msg;
    }

    /**
     * This view method returns the number of capsules according to their type,
     * there are two cases divided into two options using conditionals. Either for
     * all the projects (1) that uses a reference object for each of the objects or
     * for a current project that the user is in (2), which does not go through the
     * project cycle, only the stages
     * 
     * @param option the option 1 or 2.It's already burned in the Administration
     *               system
     * @return Message showing the amount for each type of capsule
     */
    public String amountType(int option) {
        int technical = 0, management = 0, domainSpecific = 0, experience = 0;
        boolean finish = false;
        String msg = "\n\3Capsule Type Amount:\3 ";

        for (int i = 0; i < amoProject && !finish; i++) {// project cycle created

            if (option == 1) {// reference object for each of the objects
                currentProject = projectSQA[i];
            }

            for (int j = 0; j <= currentProject.counStage(); j++) {// cycle until the last stage activated
                technical += currentProject.getStage(j).amountTypeCap("Technical");
                management += currentProject.getStage(j).amountTypeCap("Management");
                domainSpecific += currentProject.getStage(j).amountTypeCap("Domain-specific");
                experience += currentProject.getStage(j).amountTypeCap("Experience-based");
            }

            if (option == 2) {// breaks the loop when the user is in the current project
                finish = true;
            }
        }
        msg += "\n -Amount Technical: " + technical + "\n -Amount Management: " + management +
                "\n -Amount Domain-specific: " + domainSpecific + "\n -Amount Experience-based: " + experience;

        return msg;
    }

    /**
     *The project returns with the purpose that exists a project already created in the system
     * @return 
     */
    public ProjectSQA getCurrentProject() {
        return currentProject;
    }
    /**
     * This control method is in charge of searching all the registered lessons of
     * a project according to the selected stage, it will also have 2 "execution"
     * conditionals. The first(1) is in charge of using a reference project object
     * to go through the arrangement of each one of the projects with a cycle, with
     * the objective of returning the lessons of each project according to the stage
     * chosen by the user. And the second (2), only returns the lessons of the
     * project that the user is located, breaks the fix cycle with a boolean.
     * ¡The options are burned in the system!
     * 
     * @param stage     Position of the stage selected.
     * @param execution Option 1 or 2
     * @return lesson of the stage selected
     */
    public String lessonStage(int stage, int execution) {
        String msg = "";
        boolean finish = false;
        for (int i = 0; i < amoProject && !finish; i++) {

            if (execution == 1) {// reference object for each of the objects
                currentProject = projectSQA[i];
            }
            msg += currentProject.lessonStage(stage);

            if (execution == 2) {// break the loop when the user is in the current project in the terminal
                finish = true;
            }
        }
        if (projectSQA[0] == null) {
            msg = "There are no projects";
        }
        return msg;
    }

    /**
     * This control method is responsible for looking for the project that contains
     * more capsules
     * 
     * @return A project message with more capsules or that does not exist
     */
    public String moreAmountCapsule() {
        String msg = "";
        int maxium = -1;
        String project = "";

        for (int i = 0; i < amoProject; i++) {
            if (projectSQA[i].capsuleCounter() > maxium) {
                maxium = projectSQA[i].capsuleCounter();
                project = projectSQA[i].getName();
            }
        }
        msg = project + " - N#: " + maxium;
        if (projectSQA[0] == null) {
            msg = "There are no projects";
        }

        return msg;
    }

    /**
     * This control method is used with the objective to find the capsules that a
     * collaborator has registered
     * 
     * @param collaborator name of the collaborator
     * @return The message returns if there are registered capsules
     */

    public String searchCollaboratorCapsule(String collaborator) {
        String msg = "";

        for (int i = 0; i < amoProject; i++) {
            for (int j = 0; j <= projectSQA[i].counStage(); j++) {
                for (int j2 = 0; j2 < projectSQA[i].getStage(j).getCapCouter(); j2++) {

                    if (projectSQA[i].getStage(j).getCapsule(j2).getCollaborator().equalsIgnoreCase(msg)) {
                        String project = projectSQA[i].getName();
                        String stage = projectSQA[i].getStage(j).getType();
                        String capsule = projectSQA[i].getStage(j).getCapsule(j2).getId();
                        msg = "The collaborator " + collaborator + " registered in the:\n\t-Project: " + project;
                        msg += "\n\t-Stage: " + stage + "\n\t-Idcapsule: " + capsule;
                    }
                }

            }

        }
        if (msg.equals("")) {
            msg = "The collaborator was not found or no exist";
        }
        if (projectSQA[0] == null) {
            msg = "There are no projects";
        }
        return msg;
    }

    /**
     * This control method is responsible for looking for the related capsules
     * according to the key words that the user has, the system covers in each
     * hashtag and compares each other's words
     * 
     * @param text the text with keyWords
     * @return The Message With The Capsules related to the key words
     */
    public String searchCapsule(String text) {
        StringBuilder msg = new StringBuilder();
        String[] searchWord = text.split(" ");
        boolean isFound;// if was/was not found a capsule

        for (int i = 0; i < amoProject; i++) {// loop of projects

            for (int j = 0; j <= projectSQA[i].counStage(); j++) {// loop of project stage

                for (int j2 = 0; j2 < projectSQA[i].getStage(j).getCapCouter(); j2++) {// loop of stages capsules
                    isFound = false;
                    String[] hashtag = projectSQA[i].getStage(j).getCapsule(j2).getHashtag();
                    for (int k = 0; k < hashtag.length && !isFound; k++) {// loop of knowlegde capsules hashtag

                        for (int l = 0; l < searchWord.length && !isFound; l++) {// loop of the search word
                            if (hashtag[k].equalsIgnoreCase(searchWord[l])) {
                                isFound = true;
                                msg.append(projectSQA[i].getStage(j).getCapsule(i).toString());
                            }
                        } // close loop of searchWord
                    } // close loop of hashtag
                } // close loop of capsules
            } // close loop of stage
        } // close loop of project

        if (msg.length() == 0) {
            msg.append(" There are not capsules with its search text");
        }
        return msg.toString();
    }

}
