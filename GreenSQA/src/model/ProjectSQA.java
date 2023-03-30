package model;

import java.util.Calendar;

public class ProjectSQA {

	private String name;
	private double budget;
	private Calendar endDate;
	private Calendar realEnd;
	private Calendar startDate;
	private Person client;
	private Person managers;
	private int counterStage = 0;

	private Stage stage[] = {
			new Stage(TypeStage.Start),
			new Stage(TypeStage.Analysis),
			new Stage(TypeStage.Design),
			new Stage(TypeStage.Execution),
			new Stage(TypeStage.Clouse),
			new Stage(TypeStage.MonitoringAndControl)
	};

	public Stage getStage(int pos) {
		return this.stage[pos];
	}//

	public int counStage() {
		return counterStage;
	}// -

	public ProjectSQA(String name, Calendar startDate, double budget) {
		this.name = name;
		this.startDate = startDate;
		this.budget = budget;
		stage[0].setRealStart(startDate);
		stage[0].setStart(startDate);
		stage[0].setMode(true);
	}

	public String registerPerson(String name, String phone, String typePerson) {

		String register = name + "'s data was registered successfully\n";

		if (typePerson == "Clients") {
			client = new Person(name, phone, TypePerson.Costumer);

		} else {
			managers = new Person(name, phone, TypePerson.Manager);
			
		}

		return register;
	}

	public String assingDate(int[] month) {

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

		this.endDate = endDate[5];// the planned end date of the project is assigned
		return "The assing from the month was resgistered successfully\n";
	}

	public String approbationStage(Calendar realEnd) {
		String approbation="";

		if (stage[ counterStage ].getMode() != false) {

			approbation="The stage was approved";
			stage[counterStage].setMode(false);
			stage[counterStage].setRealEnd(realEnd);

			if (counterStage < 5) {
				stage[++counterStage].setRealStart(realEnd);
				stage[counterStage].setMode(true);
				approbation="se guardo la ultimia fecha de inicio";
			}

		}else{
			approbation="There are nos Stage for aprove, finish.\3";
		}
		return approbation;

	}

	public String getName() {
		return name;
	}//

	public void setRealEnd(Calendar realEnd) {
		this.realEnd = realEnd;
	}
}