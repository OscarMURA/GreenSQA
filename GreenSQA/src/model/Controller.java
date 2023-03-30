package model;

import java.util.Calendar;

public class Controller {

    private final int SIZE = 10;
    private ProjectSQA[] projectSQA = new ProjectSQA[SIZE];
    private ProjectSQA currentProject;
    private int amoProject = 0;
    private String correctFuncion = "";

    public Controller() {
    }

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

    public String registerPerson(String name, String phone, String typePerson) {
        return currentProject.registerPerson(name, phone, typePerson);
    }

    public String assingDate(int[] month) {
        return currentProject.assingDate(month);
    }

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

    public String stageName(int i) {
        return currentProject.getStage(i).getType();
    }
    public String projectName(){
        return currentProject.getName();
    }

    public int counStage() {
        return currentProject.counStage();
    }

    public String addCapsule(String id, String description, int type, String nameCollaborator, String charge,
            String learning) {

        correctFuncion = "Could not add Capsule";

        if (currentProject != null) {
            TypeCapsule typeCapsule = null;
            switch (type) {
                case 1 -> typeCapsule = TypeCapsule.Tecnic;
                case 2 -> typeCapsule = TypeCapsule.Manage;
                case 3 -> typeCapsule = TypeCapsule.Domain;
                case 4 -> typeCapsule = TypeCapsule.Experience;
            }
            Capsule capsule = new Capsule(id, description, typeCapsule, nameCollaborator, charge, learning);

            correctFuncion = currentProject.getStage(currentProject.counStage()).addCapsule(capsule);
        }

        return correctFuncion;
    }

    public String capsuleApproval(String id) {
        
        String project, stage;
        String capsule = "The calpsule with its " + id + " not exist";
        boolean isFound = false;

        for (int i = 0; i < amoProject &&!isFound; i++) {
            for (int j = 0; j < 6 && !isFound; j++) {
                if (projectSQA[i] != null) {
                    isFound = projectSQA[i].getStage(j).capsuleApproval(id);
                    
                    if(isFound){
                        project=projectSQA[i].getName();
                        stage=projectSQA[i].getStage(i).getType();
                        capsule = "The calpsule " + id + " from "+stage+"'s stage of the"+project+" project was approved. ";
                    }
                }
            }
        }
        return capsule;
    }

    public String approbationStage(Calendar realEnd) {
        return currentProject.approbationStage(realEnd);
    }

    public int positionStage() {
        return currentProject.counStage();
    }

    public String publishCapsule(){
        return "https://www.youtube.com/watch?v=dQw4w9WgXcQ";
    }
}
