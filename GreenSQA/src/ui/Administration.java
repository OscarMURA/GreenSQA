
package ui;
import model.ProjectSQA;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Administration {

	public static Scanner input=new Scanner(System.in);
	private static final int  SIZE=10; 
	private ProjectSQA[] projectSQA;
	private int projectAmount=0;
	private Scanner reader;

	public Administration(){
		projectSQA=new ProjectSQA[SIZE];
		reader=new Scanner(System.in);
	}


	public static void main(String[] args){
		
		Administration admin=new Administration();
		admin.registerProject();


	}

	public void registerProject() {
		String name="";
		String phone="";
		Calendar startDate;
		Calendar endDate;
		double budget=0;
		boolean isCostumer=false;//its variable is to choose if is project costumer or manager

		System.out.print("Type the project name: ");
		name=reader.nextLine();

		System.out.println("Type the start Date: ");
		startDate=verifyDate();

		System.out.println("Type the end Date: ");
		endDate=verifyDate();
		System.out.print("Type the project budget: ");
		budget=validateDouble();

		projectSQA[projectAmount]=new ProjectSQA(name, endDate,startDate, budget);

		projectSQA[projectAmount].registerPerson();

		 
	}



	public static double validateDouble(){
		double option=0;
        do{
        if(input.hasNextDouble()){
            
            option=input.nextDouble(); 
            input.nextLine();           
        }else{
            System.out.print("Invalid number, type a number: ");
            option=Integer.MAX_VALUE;
            input.nextLine(); 
        }
        }while(option==Integer.MAX_VALUE);

        return option;
    }

	public static Calendar verifyDate(){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		boolean correctDate=false;
		String format="";

		do{
		System.out.print("Type the date in format: dd/MM/yyyy: ");
		format=input.nextLine();

		try {
            calendar.setTime(formatDate.parse(format));
			correctDate=true;

        } catch (Exception e) {
            System.out.println("The entered date is invalid");
			correctDate=false;
        }
		}while(!correctDate);
		
		return calendar;
	}

	

	/**
	 * 
	 * @param name
	 */
	public ProjectSQA searchProjectSQA(String name) {
		// TODO - implement Administration.searchProjectSQA
		throw new UnsupportedOperationException();
	}

	public void operation() {
		// TODO - implement Administration.operation
		throw new UnsupportedOperationException();
	}

}