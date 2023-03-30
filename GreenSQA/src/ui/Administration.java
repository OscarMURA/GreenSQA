package ui;

import model.Controller;
import java.util.Calendar;
import java.util.Scanner;

public class Administration {

	private Controller controller;
	private Scanner reader;

	public Administration() {
		reader = new Scanner(System.in);
		controller = new Controller();
	}

	public static void main(String[] args) {

		int option = 0;
		boolean follow = false;

		Administration admin = new Administration();

		do {
			admin.lines();
			System.out.println("\n\3Project's Management\3\n");

			System.out.println("1.Creacte project\n2.Search Project\n3.Culminate capsule\n4.Publish Capsule ");

			do {
				System.out.print("Correctly Type the option: ");
				option = admin.validateOption();
			} while (option < 1 || option > 4);

			follow = admin.principalExecution(option);

			if (follow == true) {

				do {
					option = admin.proMenu();
					lines();
					admin.projectExecution(option);

				} while (option != 0 && option != 5);

			}

		} while (option != 0);

	}

	public int proMenu() {
		int option = 0;

		lines();
		System.out.println("\3" + controller.projectName() + " Project menu\3\n");
		System.out.println("1.Register Capsule\n2.Aprobation Capsule\n3.Culminate Stage\n4.Go to menu\n0.Exit");

		do {
			System.out.print("Correctly Type the option: ");
			option = validateOption();
		} while (option < 0 || option > 5);

		return option;

	}

	public boolean principalExecution(int option) {
		boolean follow = false;
		switch (option) {

			case 1:
				registerProject();
				follow = true;
				break;

			case 2:
				follow = searchProject();
				break;

			case 3:
				capsuleApproval();
				break;

			case 4:
				publishCapsules();
				break;
		}
		return follow;

	}

	public void projectExecution(int option) {
		switch (option) {

			case 1 -> registerCapsule();

			case 2 -> capsuleApproval();

			case 3 -> stageApprobation();

			case 0 -> System.out.println("You went out of the program. ");
		}
	}

	public static void lines() {
		System.out.println("\n\3=======================================================================\3 \n");
	}

	public void registerProject() {

		String name = "";
		Calendar startDate = Calendar.getInstance();
		double budget = 0;

		lines();
		System.out.println("\3Register Projects\3\n");
		System.out.print("Type the project name: ");
		name = read(reader);
		System.out.print("Type the project budget: ");
		budget = validateDouble();
		controller.registerProject(name, startDate, budget);
		controller.searchProjectSQA(name);
		registerPerson();
		assingDate();

	}

	private void registerPerson() {

		String name="", phone="";
		lines();
		System.out.println("\3Register Client and Manager\3\n");
		for (int i = 0; i < 2; i++) {

			String typePerson = (i == 0) ? "Clients" : "Manager";
			System.out.print("Type your " + typePerson + " name: ");
			name = read(reader);
			System.out.print("Type your " + typePerson + " phone: ");
			phone = reader.next();
			System.out.println(controller.registerPerson(name, phone, typePerson));

		}
	}

	public void assingDate() {
		int[] month = new int[6];

		lines();
		System.out.println("\3Assing tha date for each stage\3 \nHow long months it will carry the ");

		for (int i = 0; i < month.length; i++) {

			System.out.print((i + 1) + ". " + controller.stageName(i) + "'s stage:  ");
			month[i] = reader.nextInt();
		}

		System.out.println(controller.assingDate(month));

	}

	public boolean searchProject() {
		String name = "";
		boolean isFound = false;

		lines();
		System.out.print("\3Search Project\3 \nType project's name:  ");
		name = read(reader);
		isFound = controller.searchProjectSQA(name);
		if (isFound) {
			System.out.println("The " + name + "'s  project was found");
		} else {
			System.out.println("The " + name + "'s  project was NOT found");
		}
		return isFound;

	}

	public void publishCapsules() {

		lines();
		System.out.println("\3Publish Capsules\3");
		System.out.println("Url important to see: " + controller.publishCapsule());
	}

	public double validateDouble() {
		double option = 0;

		do {
			if (reader.hasNextDouble()) {
				option = reader.nextDouble();
			} else {
				reader.next();// limpiar el scanner
				option = Integer.MAX_VALUE;
				System.out.print("Invalid number, type a number: ");

			}
		} while (option == Integer.MAX_VALUE);

		return option;
	}

	public int validateOption() {
		int option = 0;
		do {
			if (reader.hasNextInt()) {

				option = reader.nextInt();

			} else {
				reader.next();
				System.out.print("Invalid number! Type number ");
				option = Integer.MAX_VALUE;

			}

		} while (option == Integer.MAX_VALUE);

		return option;
	}

	/**
	 * Control function in order to avoid errors when the terminal reads
	 * 
	 * @param scanner Scanner object
	 * @return Return the entire line as a String
	 */
	public String read(Scanner scanner) {
		scanner.useDelimiter(System.lineSeparator());
		String linea = scanner.next();
		scanner.useDelimiter("\\p{javaWhitespace}+");
		return linea;
	}

	public void stageApprobation() {

		int option = 0;
		lines();
		System.out.println("\3Stage approval\3\n");
		System.out
				.print(" Do you want to approve the " + controller.stageName(controller.positionStage()) + "'s stage");

		do {
			System.out.print(" Yes(1) or No(2): ");
			option = validateOption();
		} while (option > 2 || option < 1);

		if (option == 1) {
			Calendar realEnd = Calendar.getInstance();
			System.out.println(controller.approbationStage(realEnd));
		} else {
			System.out.println("\nYou came out correctly.");
		}

	}

	public void registerCapsule() {
		String id="", description="", name="", charge="", learning="", hashtag;
		int typeCapsule;

		lines();
		System.out.println("\3Register " + controller.stageName(controller.counStage()) + " capsule \3 \n ");
		System.out.print("Type the Capsule id: ");
		id = reader.next();

		do{
			System.out.print("Type the description id with word key(#sush as#): ");
			description = read(reader);
			hashtag="";//////////////////corregir
		}while(hashtag=="");

		System.out.println("Capsule Type:\n1.Tecnic\n2.Manage\n3.Domain\n4.Experence");

		do {
			System.out.print("Correctly enter the capsule type: ");
			typeCapsule = validateOption();
		} while (typeCapsule < 1 || typeCapsule > 4);

		System.out.print("\nEnter the collaborator name: ");
		name = read(reader);
		System.out.print("Enter the collaborator charge: ");
		charge = read(reader);
		System.out.print("Enter the lesson learned from the situation: ");
		learning = read(reader);
		System.out.println(controller.addCapsule(id, description, typeCapsule, name, charge, learning));
	}

	public String[] capsuleHashtag(String description) {
		String hashtag[] = new String[10];
		int finaL=-1,init=-1,contador=0, par=0;
		
		for (int i = 0; i < description.length(); i++) {
			if(description.charAt(i)=='#'){
				contador++;

				if(contador%2==0){
					par++;
					init = description.indexOf("#", finaL);
					finaL = description.indexOf("#", init + 1);
					
				}	
			}
		}
	

		init = description.indexOf("#");
		finaL = description.indexOf("#", init + 1);
		
		return hashtag;
	
	}

	public void capsuleApproval() {

		String id = "";
		lines();
		System.out.println("\3Casule Aprobation\3 \n");
		System.out.print("Type the capsule's id: ");
		id = read(reader);
		System.out.println(controller.capsuleApproval(id));
	}
}
