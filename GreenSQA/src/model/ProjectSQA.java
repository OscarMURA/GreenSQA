package model;

import java.util.Calendar;

public class ProjectSQA {

	private String name;
	private double budget;

	private Calendar endDate;
	private Calendar realEnd;
	private Calendar startDate;
	private Calendar realStart;

	private Stage stage[] = {

			new Stage(TypeStage.Start),
			new Stage(TypeStage.Analysis),
			new Stage(TypeStage.Design),
			new Stage(TypeStage.Execution),
			new Stage(TypeStage.Clouse),
			new Stage(TypeStage.MonitoringAndControl)

	};
	private Person client;
	private Person[] managers = new Person[10];

	private int counterStage = 0;
	private int counterManager = 0;

	public String getNameStage(int pos) {
		return this.stage[pos].getType();
	}

	public int getCounterStage() {
		return counterStage;
	}

	public ProjectSQA(String name, Calendar startDate, double budget) {
		this.name = name;

		this.startDate = startDate;
		this.budget = budget;
		stage[0].setRealStart(startDate);
		stage[0].setStart(startDate);
		stage[0].setMode(true);
	}

	public boolean registerPerson(String name, String phone, String typePerson) {
		boolean correctSave = false;

		if (typePerson == "Clients") {
			client = new Person(name, phone, TypePerson.Costumer);
			correctSave = true;

		} else {
			managers[counterManager++] = new Person(name, phone, TypePerson.Manager);
			correctSave = true;

		}
		return correctSave;
	}

	public boolean assingDate(int[] month) {

		Calendar startDate[] = new Calendar[6];
		Calendar endDate[] = new Calendar[6];

		endDate[0] = stage[0].getStart();
		endDate[0].add(Calendar.MONTH, month[0]);
		stage[0].setEnd(endDate[0]);

		for (int j = 1; j < month.length; j++) {

			startDate[j] = endDate[j - 1];

			stage[j].setStart(startDate[j]);
			endDate[j] = startDate[j];
			endDate[j].add(Calendar.MONTH, month[j]);

			stage[j].setEnd(endDate[j]);

		}

		return true;
	}

	public boolean aprobation(Calendar realEnd) {

		stage[counterStage].setMode(false);
		stage[counterStage].setRealEnd(realEnd);

		if (counterStage < 6) {
			stage[++counterStage].setRealStart(realEnd);
		}
		return true;

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

	public Calendar getRealEnd() {
		return realEnd;
	}

	public void setRealEnd(Calendar realEnd) {
		this.realEnd = realEnd;
	}

	public Calendar getRealStart() {
		return realStart;
	}

	public void setRealStart(Calendar realStart) {
		this.realStart = realStart;
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