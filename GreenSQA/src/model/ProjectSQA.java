package model;

import java.util.Calendar;
import java.text.SimpleDateFormat;
public class ProjectSQA {

	private String name;
	private double budget;
	private Calendar endDate;
	private Calendar realEnd;
	private Calendar startDate;
	private Person client;
	private Person managers;
	private int counterStage = 0;

	private SimpleDateFormat view = new SimpleDateFormat("dd/MM/yyyy 'hours: ' hh:mm:ss a");
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
		this.startDate =(Calendar) startDate.clone() ;
		this.budget = budget;

		stage[0].setRealStart(  (Calendar) startDate.clone()  );
		stage[0].setStart( (Calendar) startDate.clone()  );
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

		/*
		 * To assign the date from one Calendar object to another Calendar object safely 
		 * and to avoid errors, the .clone() method can be used to create a copy of the original 
		 * object. In this way, if one of the instances is modified, the other will not be affected.
		 */

		String init =view.format( this.startDate.getTime() ); //for show the start date of the project
		
		endDate[0] = (Calendar) stage[0].getStart().clone();
		endDate[0].add(Calendar.MONTH, month[0]);
		stage[0].setEnd( (Calendar) endDate[0].clone()    );

		for (int j = 1; j < month.length; j++) {

			startDate[j] = (Calendar) endDate[j - 1].clone();
			stage[j].setStart(  (Calendar) startDate[j].clone());
			endDate[j] = (Calendar) startDate[j].clone();	
			endDate[j].add(Calendar.MONTH, month[j]);		
			stage[j].setEnd(  (Calendar) endDate[j].clone());
			

		}
	
		this.endDate = (Calendar) stage[5].getEnd().clone();// the planned end date of the project is assigned
		return "The assing from the month was resgistered successfully\n"+name+
		" project: \n-Planned Start date= "+init+"\n-Planned end date= "+view.format(this.endDate.getTime());
	}

	public String approbationStage(Calendar realEnd) {
		String approbation="";
		
		if (stage[ counterStage ].getMode() != false) {

			stage[counterStage].setMode(false);
			stage[counterStage].setRealEnd(  (Calendar) realEnd.clone() );
			approbation="The stage "+getStage(counterStage).getType()+" was approved on "+view.format( stage[counterStage].getRealEnd().getTime()  );
			
			if (counterStage < 5) {
				this.realEnd=realEnd;
				stage[++counterStage].setRealStart((Calendar) realEnd.clone());
				stage[counterStage].setMode(true);
				
			}

		}else{
			String init=view.format(this.startDate.getTime());//for show the start date of the project
			approbation="All the stage was approved. "+name+"'s project:\n-Real start date:"+
			init+"\n-Real end Date: "+view.format(this.realEnd.getTime());
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