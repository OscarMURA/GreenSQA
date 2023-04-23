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
	private boolean publish = false;

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
	 * Returns if the capsule is already published or not
	 * 
	 * @return True: is published, False: Not published
	 */
	public boolean getPublish() {
		return this.publish;
	}

	/**
	 * Control method to save that a capsule is already published
	 * @param publish True, for change to capsule already published
	 */
	public void setPublish(boolean publish) {
		this.publish = publish;
	}

	/**
	 * Saves the approval of the capsule by accepting a true
	 * 
	 * @param aprobation 
	 */
	public void setAprobation(boolean aprobation) {
		this.aprobation = aprobation;
	}

	public boolean getAprobation() {
		return this.aprobation;
	}

	public String[] getHashtag() {
		return hashtag;
	}

	/**
	 * Save the capsule approval date
	 * 
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

	/**
	 * This control method returns in a text chain returns the important data of the
	 * capsule
	 * 
	 * @return Primordial data of the capsule
	 */

	public String toString() {
		StringBuilder capsule = new StringBuilder();
		capsule.append("\n \nCapsule: " + id);
		capsule.append("\tCollaborator: " + Collaborator);
		capsule.append("\tCharge: " + charge);
		capsule.append("\n\3Description of the situation: " + description);
		capsule.append("\n\3Lesson learned: " + learning);
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