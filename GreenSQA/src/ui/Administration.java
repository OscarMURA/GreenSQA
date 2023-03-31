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
		double option = 0;
		boolean follow = false;

		Administration admin = new Administration();

		do {
			admin.lines();
			System.out.println("\n\3Project's Management\3\n");

			System.out.println("1.Creacte project\n2.Search Project\n3.Culminate capsule\n4.Publish Capsule\n0.Exit ");

			do {
				System.out.print("Correctly Type the option: ");
				option = admin.validateDouble();

			} while (option!=1.0 && option!=2.0 && option!=3.0 && option!=4.0 && option!=0);
			
			follow = admin.principalExecution((int)option);

			if (follow == true) {
				do { 

					option = admin.menuProject();
					lines();
					admin.projectExecution( (int)option );

				} while (option != 0 && option != 4);

			}
		} while (option != 0);
	}

	public double menuProject() {
		double option = 0;
		lines();
		System.out.println("\3" + controller.projectName() + " Project menu\3\n");
		System.out.println("1.Register Capsule\n2.Aprobation Capsule\n3.Culminate Stage\n4.Go to menu\n0.Exit");
		do {
			System.out.print("Correctly Type the option: ");
			option = validateDouble();
		} while (option!=1.0 && option!=2.0 && option!=3.0 && option!=4.0 && option != 0.0);

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

		String name = "", phone = "";
		lines();
		System.out.println("\3Register Client and Manager\3\n");
		for (int i = 0; i < 2; i++) {

			String typePerson = (i == 0) ? "Clients" : "Manager";
			System.out.print("Type the " + typePerson + " name: ");
			name = read(reader);
			System.out.print("Type the " + typePerson + " phone: ");
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

	/**
	 * Control function in order to avoid errors when the terminal reads
	 * 
	 * @param scanner Scanner object
	 * @return Return the entire line as a String
	 */
	public String read(Scanner scanner) {
		String linea="";
		do{
			scanner.useDelimiter(System.lineSeparator());
			linea = scanner.next();
			scanner.useDelimiter("\\p{javaWhitespace}+");
		}while(linea.equalsIgnoreCase(""));
		return linea;
	}

	public void stageApprobation() {
		lines();
		System.out.println("\3Stage approval\3\n");
		Calendar realEnd = Calendar.getInstance();
		System.out.println(controller.approbationStage(realEnd));
	}

	public void registerCapsule() {

		String id = "", description = "", name = "", charge = "", learning = "";
		String[] hashtag = new String[20];
		double typeCapsule;

		lines();
		System.out.print("\3Register " + controller.stageName(controller.counStage()) + " capsule \3 \n Type the Capsule id: ");
		id = reader.next();
		int free = 0;
		do {
			free = getFirstValidPosition(hashtag);
			System.out.print("Type the description id with word key(#sush as#): ");
			description = read(reader);
			hashtag = capsuleHashtag(description, hashtag);
		} while (hashtag[free] == null);

		System.out.println("Capsule Type:\n1.Tecnic\n2.Manage\n3.Domain\n4.Experence");

		do {
			System.out.print("Correctly enter the capsule type: ");
			typeCapsule = validateDouble();
		} while (typeCapsule!=1.0 && typeCapsule!=2.0 && typeCapsule!=3.0 && typeCapsule!=4.0);

		System.out.print("\nEnter the collaborator name: ");
		name = read(reader);
		System.out.print("Enter the collaborator charge: ");
		charge = read(reader);
		do {
			free = getFirstValidPosition(hashtag);
			System.out.print("Enter the lesson learned from the situation: ");
			learning = read(reader);
			hashtag = capsuleHashtag(learning, hashtag);
		} while (hashtag[free] == null);
		System.out.println(controller.addCapsule(id, description, (int)typeCapsule, name, charge, learning));
	
	}

	public String[] capsuleHashtag(String description, String[] wordKey) {
		int finaL = 0, init = 0, contador = 0, pos = 0;
		for (int i = 0; i < description.length(); i++) {

			if (description.charAt(i) == '#') {
				contador++;

				if (contador % 2 == 0) {
					init = description.indexOf("#", finaL);
					finaL = description.indexOf("#", init + 1);
					pos = getFirstValidPosition(wordKey);
					wordKey[pos] = description.substring(init + 1, finaL);
					finaL += 2;
				}
			}
		}
		return wordKey;
	}

	public int getFirstValidPosition(String[] wordKay) {
		int pos = -1;
		boolean isFound = false;
		for (int i = 0; i < wordKay.length && !isFound; i++) {
			if (wordKay[i] == null) {
				pos = i;
				isFound = true;
			}
		}
		return pos;
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
