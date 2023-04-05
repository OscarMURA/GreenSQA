package model;

import java.util.Calendar;

/**
 * This capsule class has the properties of a capsule object
 */
public class Capsule {

	private String id;
	private String description;
	private TypeCapsule typeCapsule;
	private String Collaborator;
	private String charge;
	private String learning;
	private Calendar aprobationDate = null;
	private boolean aprobation = false;
	private String hashtag[] = new String[20];

	/**
	 * Builder method from the Capsule class
	 * 
	 * @param id
	 * @param description
	 * @param typeCapsule
	 * @param nameColaborator
	 * @param position
	 * @param learning
	 */
	public Capsule(String id, String description, TypeCapsule typeCapsule, String Collaborator, String charge,
			String learning, String[] hashtag) {
		this.id = id;
		this.description = description;
		this.typeCapsule = typeCapsule;
		this.Collaborator = Collaborator;
		this.charge = charge;
		this.learning = learning;
		this.hashtag = hashtag;
	}

	/**
	 * @return returns the id of the capsule
	 */
	public String getId() {
		return id;
	}

	/**
	 * Saves the approval of the capsule by accepting a true
	 * 
	 * @param aprobation
	 */
	public void setAprobation(boolean aprobation) {
		this.aprobation = aprobation;
	}

	/**
	 * Save the capsule approval date
	 * @param aprobaDate the capsule approval date
	 */

	public void setAprobationDate(Calendar aprobaDate) {
		this.aprobationDate = aprobaDate;

	}

	/**
	 * 
	 * @return Returns the capsule approval date
	 */
	public Calendar getAprobationDate() {
		return aprobationDate;
	}

	
	public String toString() {
		StringBuilder capsule = new StringBuilder();
		capsule.append("\n \nCapsule: " + id);
		capsule.append("\tCollaborator: " + Collaborator);
		capsule.append("\tCharge: " + charge);
		capsule.append("\n\3Description: " + description);
		capsule.append("\n\3Lesson leaned: " + learning);

		return capsule.toString();
	}

	/**
	 * @return the type of the capsule
	 */
	public String getTypeCapsule() {
		return typeCapsule.getType();
	}

	/**
	 * 
	 * @return Returns the name of the collaborator
	 */
	public String getCollaborator() {
		return Collaborator;
	}

	/**
	 * 
	 * @return Return the lesson learned of the capsule
	 */
	public String getLearning() {
		return learning;
	}
}