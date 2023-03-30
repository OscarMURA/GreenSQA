package model;
import java.util.Calendar;

public class Capsule {

	private String id;
	private String description;
	private TypeCapsule typeCapsule;
	private String nameCollaborator;
	private String charge;
	private String learning;
	private Calendar aprobationDate=null;
	private boolean aprobation=false;




	/**
	 * constructor method from the Capsule class
	 * 
	 * @param id
	 * @param description
	 * @param typeCapsule
	 * @param nameColaborator
	 * @param position
	 * @param learning
	 */
	public Capsule(String id, String description, TypeCapsule typeCapsule, String nameCollaborator, String charge, String learning) {
		this.id=id;
		this.description=description;
		this.typeCapsule=typeCapsule;
		this.nameCollaborator=nameCollaborator;
		this.charge=charge;
		this.learning=learning;
	}

	public String getId(){
		return id;
	}

	public void setAprobation(boolean aprobation) {
		this.aprobation = aprobation;
	}

	public void setAprobationDate(Calendar aprobaDate){
		this.aprobationDate=aprobaDate;

	}

	public Calendar getAprobationDate() {
		return aprobationDate;
	}

	public String toString(){
		StringBuilder capsule=new StringBuilder();
		capsule.append("\n \nCapsule: "+id);
		capsule.append("\tAprobation Date: "+aprobationDate);
		capsule.append("Collaborator: "+nameCollaborator);
		capsule.append("\nCharge: "+charge);
		capsule.append("\n \n"+description);
		capsule.append("Lesson leaned: "+learning);

		return capsule.toString();
	}


}