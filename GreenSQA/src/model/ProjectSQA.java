package model;

import java.util.Calendar;
import java.util.Scanner;

public class ProjectSQA {

	private String name;
	private Calendar endDate;
	private Calendar startDate;
	private double budget;
	private Person[] clients;
	
	private Person[] manager;
	


	private Scanner input = new Scanner(System.in);
	private Stage stage;
	private int month;

	public ProjectSQA(String name, Calendar endDate, Calendar startDate, double budget) {
		this.name = name;
		this.endDate = endDate;
		this.startDate = startDate;
		this.budget = budget;
	}

	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param endDate
	 */
	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	public Calendar getEndDate() {
		return this.endDate;
	}

	public Calendar getStartDate() {
		return this.startDate;
	}

	/**
	 * 
	 * @param startDate
	 */
	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public double getBudget() {
		return this.budget;
	}

	/**
	 * 
	 * @param budget
	 */
	public void setBudget(double budget) {
		this.budget = budget;
	}

	/**
	 * 
	 * @param name
	 * @param endDate
	 * @param startDate
	 * @param budget
	 */

	public void registerPerson() {
		int amount = 0;
		String name = "";
		String phone = "";
		int j = 1;

		do {
			String subject = (j == 1) ? "clients" : "Manager";

			System.out.println("How many project  " + subject + "  are you goint to enter?: ");
			amount = input.nextInt();
			clients = new Person[amount];

			for (int i = 0; i < amount; i++) {

				System.out.print("Enter the " + subject + " name: ");
				name = input.nextLine();
				input.nextLine();

				System.out.print("Enter the " + subject + " phone: ");
				phone = input.next();

				if (j == 1) {
					clients[i] = new Person(name, phone, TypePerson.Costumer);
					

				} else if (j == 2) {
					manager[i] = new Person(name, phone, TypePerson.Manager);
					
				}

			}
			j++;
		} while (j <= 2);

	}

	/**
	 * 
	 * @param stage
	 */
	public void stageAdministration(Stage[] stage) {
		// TODO - implement ProjectSQA.stageAdministration
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param stage
	 */
	public String stageApprobation(Stage[] stage) {
		// TODO - implement ProjectSQA.stageApprobation
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param stage
	 */
	public String registerCapsule(Stage[] stage) {
		// TODO - implement ProjectSQA.registerCapsule
		throw new UnsupportedOperationException();
	}

}