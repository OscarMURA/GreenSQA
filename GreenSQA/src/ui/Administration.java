

import model.Controller;

import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Administration {

	public static Scanner input=new Scanner(System.in);
	

	
	private Controller controller;
	private Scanner reader;
	private boolean correctFuncion=false;

	public Administration(){

		reader=new Scanner(System.in);
		controller=new Controller();

	}


	public static void main(String[] args){
		System.out.println("Hola mundo");
		Administration admin=new Administration();
		admin.registerProject();


	}

	public void registerProject() {
		String name="";
	
		Calendar startDate=Calendar.getInstance();

		double budget=0;
		
		System.out.println(11);
		System.out.print("Type the project name: ");
		name=reader.nextLine();

		System.out.print("Type the project budget: ");
		budget=validateDouble();

		controller.registerProject(name, startDate, budget);

		registerPerson();
	}


	private void registerPerson() {
		String name;
		String phone;
		int i=0;
		correctFuncion=false;
		do{

		String typePerson=(i==0)?"Clients":"Manager";
		System.out.print("How many project "+typePerson+" will you enter? ");
		int amount=input.nextInt();

		for (int j = 0; j < amount; j++) {
			

			System.out.print("Type your name: ");
			name=reader.nextLine();
			System.out.print("\nType yout phone: ");
			phone=reader.next();

			correctFuncion=controller.registerPerson(name, phone, typePerson);

			System.out.println("The "+name+"'s data was saver?: "+correctFuncion);

		}
		}while(i<2);
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

	
	
	public void stageApprobation(){

		int option=0;
		System.out.print(" Estas seguro qur quieres aprobar  "+controller.presentStageName());
		System.out.print(" Si(1) o No(2): ");
		option=reader.nextInt();


		if(option==1){
			Calendar realEnd=Calendar.getInstance();
			controller.aprobationStage(realEnd);
		} else{
			System.out.println("\nYou came out correctly.");
		}

	}

	public void assingDate(){
		correctFuncion=false;
		int[] month=new int[6];
		System.out.println("\3Assing tha date for each stage\3 ");

		for (int i = 0; i <month.length; i++) {
			System.out.print(" How long months it will carry tha stage  "+controller.presentStageName());
			month[i]=reader.nextInt();
		}

		correctFuncion=controller.assingDate(month);

		System.out.println("Se asignaron correctamente la fechas? "+correctFuncion);
		System.out.println();
	}



}

