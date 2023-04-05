package model;

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
    private String correctFuncion = "";

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
    public String registerProject(String name, Calendar startDate, double budget) {
        String register = "The project was not register succesfully, no space to register\n";

        if (amoProject != projectSQA.length) {

            projectSQA[amoProject] = new ProjectSQA(name, startDate, budget);
            register = "The project was register succesfully\n";
            currentProject = projectSQA[amoProject];
            amoProject++;
        }
        return register;
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

        if (currentProject != null) {
            TypeCapsule typeCapsule = null;
            switch (type) {
                case 1 -> typeCapsule = TypeCapsule.Tecnic;
                case 2 -> typeCapsule = TypeCapsule.Manage;
                case 3 -> typeCapsule = TypeCapsule.Domain;
                case 4 -> typeCapsule = TypeCapsule.Experience;
            }
            Capsule capsule = new Capsule(id, description, typeCapsule, nameCollaborator, charge, learning, hashtag);
            correctFuncion = currentProject.getStage(currentProject.counStage()).addCapsule(capsule);
        }

        return correctFuncion;
    }

    /**
     * Method to approve the capsules from their id
     * 
     * @param id
     * @return if the capsule exists, it was approved, otherwise
     */
    public String capsuleApproval(String id) {

        String project, stage;
        String capsule = "The calpsule with its " + id + " not exist";
        boolean isFound = false;

        for (int i = 0; i < amoProject && !isFound; i++) {
            for (int j = 0; j < 6 && !isFound; j++) {
                if (projectSQA[i] != null) {

                    isFound = projectSQA[i].getStage(j).capsuleApproval(id);
                    if (isFound) {
                        project = projectSQA[i].getName();
                        stage = projectSQA[i].getStage(i).getType();
                        capsule = "The calpsule " + id + " from " + stage + "'s stage of the" + project
                                + " project was approved. ";
                    }
                }
            }
        }
        return capsule;
    }

    /**
     * Displays the name of a project stage.
     * 
     * @param i: Position of a stage within a project.
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
     * URL for publishing approved capsules related to organizational interests.
     * @return The URL for the published capsules.
     */
    public String publishCapsule() {
        return " \3 https://www.youtube.com/watch?v=dQw4w9WgXcQ  \3";
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
}
