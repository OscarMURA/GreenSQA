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
			} while (option != 1.0 && option != 2.0 && option != 3.0 && option != 4.0 && option != 0);

			follow = admin.principalExecution((int) option);

			if (follow == true) {
				do {

					admin.menuProject();
					lines();
					do {
						System.out.print("Correctly Type the option: ");
						option = admin.validateDouble();
					} while (option != 1.0 && option != 2.0 && option != 3.0 && option != 4.0 && option != 0.0);

					admin.projectExecution((int) option);
				} while (option != 0 && option != 4);

			}
		} while (option != 0);
	}

	/**
	 * View method that shows the Options from the projects menu such as registering
	 * capsules or approving stages
	 */
	public void menuProject() {
		lines();
		System.out.println("\3" + controller.projectName() + " Project menu\3\n");
		System.out.println("1.Register Capsule\n2.Aprobation Capsule\n3.Culminate Stage\n4.Go to menu\n0.Exit");
	}

	/**
	 * Runs the main sismeta menu, and returns a boolean yes to enter the project
	 * menu if found
	 * 
	 * @param option the option chosen by the user
	 * @return if true, you can enter the project menu otherwise it stays the same
	 */
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

	/*
	 * This method executes the project menu options, either register capsules,
	 * approve capsules or approve stages
	 */
	public void projectExecution(int option) {
		switch (option) {
			case 1 -> registerCapsule();
			case 2 -> capsuleApproval();
			case 3 -> stageApprobation();
			case 0 -> System.out.println("You went out of the program. ");
		}
	}

	/** decoration of lines for the terminal
	 */
	public static void lines() {
		System.out.println("\n\3=======================================================================\3 \n");
	}

	/**
	 * This control method is responsible for registering the projects, entering the
	 * name and the amount of investment. In order to create a project object by
	 * calling the controller
	 */
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

	/**
	 * This control method registers the client and manager of an existing project
	 * by calling the registerPerson() method and printing the result if the
	 * registration was successful. It uses a for loop to recycle variables, and
	 * depending on the type of person, the system registers them in the appropriate
	 * place.
	 */
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

	/**This control method assigns the duration of months of each stage going through a cycle
	 * stores them in an array of 6, with the goal of sending it to the class
	 * projectSQA and this assigns the start and end dates
	 * planned for each stage of the project
	 */
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

	/**
	 * This control method searches for a project and performs the actions shown in
	 * the menuProject on the current project if found.
	 * @return a boolean, true if found, false otherwise
	 */
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

	/**
	 * Displays the URL of the published capsules
	 */
	public void publishCapsules() {
		lines();
		System.out.println("\3Publish Capsules\3");
		System.out.println("Url important to see: " + controller.publishCapsule());
	}

	/**
	 * Control/View method that verifies if the input is a number, and can also be
	 * used to verify options with necessary restrictions.
	 * 
	 * @return The validated double value
	 */
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
	 * Control method used to verify text strings with spaces for any issues.
	 * This was implemented to prevent reading problems. 😃
	 * @param scanner Scanner object
	 * @return Returns the entire line as a String
	 */
	public String read(Scanner scanner) {
		String line = "";
		do {
			scanner.useDelimiter(System.lineSeparator());
			line = scanner.next();
			scanner.useDelimiter("\\p{javaWhitespace}+");
		} while (line.equalsIgnoreCase(""));
		return line;
	}

	/**
	 * This method shows that the stage has been approved, by instantiating a
	 * calendar variable to store the actual end date of the stage.
	 */
	public void stageApprobation() {
		lines();
		System.out.println("\3Stage approval\3\n");
		Calendar realEnd = Calendar.getInstance();
		System.out.println(controller.approbationStage(realEnd));
	}

	/**
	 * This view method registers the capsules to send them to the controller
	 * method and thus create the project's capsules of its current stage. The
	 * controller returns whether it was saved or not.
	 */

	public void registerCapsule() {
		String id = "", description = "", name = "", charge = "", learning = "";
		String[] hashtag = new String[20];
		double typeCapsule;

		lines();
		System.out.print(
				"\3Register " + controller.stageName(controller.counStage()) + " capsule \3 \n Type the Capsule id: ");
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
		} while (typeCapsule != 1.0 && typeCapsule != 2.0 && typeCapsule != 3.0 && typeCapsule != 4.0);

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
		System.out.println(controller.addCapsule(id, description, (int) typeCapsule, name, charge, learning, hashtag));

	}

	/**
	 * This method searches for words or text strings that contain '#' and stores
	 * them in an array as keywords for each capsule, to subsequently use another
	 * method to search for them.
	 *
	 * At the moment it will only extract 10 capsules in description and lesson
	 * @param description the variable that contains the text with the '#'
	 * @param wordKey     the array that will store the '#'
	 * @return the array with the found keywords
	 */
	public String[] capsuleHashtag(String description, String[] wordKey) {
		int finaL = 0, init = 0, contador = 0, pos = 0;
		for (int i = 0; i < description.length() && contador<20; i++) {
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

	/**
	 * Finds the free position of an array
	 * @param array Array to search for free space
	 * @return Returns the space if found, -1 otherwise.
	 */

	public int getFirstValidPosition(String[] array) {
		int pos = -1;
		boolean isFound = false;
		for (int i = 0; i < array.length && !isFound; i++) {
			if (array[i] == null) {
				pos = i;
				isFound = true;
			}
		}
		return pos;
	}

	/**
	 * view method that looks for the capsules to approve them, and prints if it
	 * exists
	 * approved otherwise
	 */
	public void capsuleApproval() {
		String id = "";
		lines();
		System.out.println("\3Casule Aprobation\3 \n");
		System.out.print("Type the capsule's id: ");
		id = read(reader);
		System.out.println(controller.capsuleApproval(id));
	}
}
