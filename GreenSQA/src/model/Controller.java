package model;

import java.util.Calendar;


public class Controller {

    private final int SIZE = 10;
    private ProjectSQA[] projectSQA = new ProjectSQA[SIZE];
    private int amoProject = 0;
    private int position=0;

    public Controller() {
    }

    public boolean registerProject(String name, Calendar startDate, double budget) {
        
        position=amoProject;
        projectSQA[amoProject] = new ProjectSQA(name, startDate, budget);
        return true;

    }

    public boolean registerPerson(String name, String phone, String typePerson) {

        position=amoProject;
        return projectSQA[amoProject++].registerPerson(name, phone, typePerson);

    }

    public String presentStageName() {
        return projectSQA[position].getNameStage(projectSQA[position].getCounterStage());

    }

    public boolean assingDate( int[] month) {
        return projectSQA[position].assingDate(month);

    }

    public boolean aprobationStage(Calendar realEnd){
        return projectSQA[position].aprobation(realEnd);

    }


    public boolean searchProjectSQA(String name ){
        boolean isFound=false;

        for (int i = 0; i < amoProject&&isFound; i++) {

            if(name.equalsIgnoreCase( projectSQA[i].getName() )){
                position=i;
                isFound=true;
            }
        }

        return isFound;
    }

}
