package model;

import java.util.Calendar;

/**
 * This stage class is in charge of having the properties and functions of a
 * stage object, and containing in it an instance arrangement of the capsule
 * class
 */
public class Stage {

	private TypeStage typeStage;
	private Calendar start;
	private Calendar end;
	private Calendar realStart;
	private Calendar realEnd;
	private boolean mode = false;
	private Capsule capsule[] = new Capsule[50];
	private int capCouter = 0;

	public Stage(TypeStage typeStage) {
		this.typeStage = typeStage;

	}

	public Capsule getCapsule(int i) {
		return capsule[i];
	}

	/**
	 * This method returns the number of registered capsules of each stage *
	 *  @return Capsule amount registered
	 */
	public int getCapCouter() {
		return capCouter;
	}

	/**
	 * Control method that adds capsules as long as its counter is less than the
	 * size of the array where it is stored
	 * 
	 * @param capsule
	 * @return Message if saved or not
	 */
	public String addCapsule(Capsule capsule) {

		String register = "The capsule was not registered successfully, no space to add\n";

		if (capCouter != this.capsule.length) {

			this.capsule[capCouter++] = capsule;
			register = "The capsule was registered successfully\n";
		}
		return register;
	}

	/**
	 * @return Returns the in String data the type of stage that the object is
	 */
	public String getType() {
		return this.typeStage.getType();
	}

	/**
	 * Approve knowledge capsules through the id of the capsule, with the help of
	 * the method of finding capsules. Also, save the aprobation date of the capsule
	 * 
	 * @param id
	 * @param aprobationDate
	 * @return true: the capsule was approved, false: the capsule did not exist and
	 *         was not approved
	 */
	public boolean capsuleApproval(String id, Calendar aprobationDate) {
		boolean aprobation = false;

		if (searchCapsule(id) != (null)) {

			searchCapsule(id).setAprobation(true);
			searchCapsule(id).setAprobationDate(aprobationDate);
			aprobation = true;
		}

		return aprobation;
	}

	/**
	 * Search for a capsule object by its id or its type
	 * 
	 * @param id
	 * @return returns a capsule object, but if it is different from null it means
	 *         that it found the capsule
	 */

	public Capsule searchCapsule(String id) {

		Capsule capsule = null;
		boolean isFound = false;

		for (int i = 0; i < this.capsule.length && !isFound; i++) {
			if (this.capsule[i] != null && this.capsule[i].getId().equalsIgnoreCase(id)) {
				capsule = this.capsule[i];
				isFound = true;
			}
		}
		return capsule;
	}

	/**
	 * This voew method counts the quantity of a type of capsule
	 * 
	 * @param word type capsule
	 * @return counts of a type of capsule
	 */
	public int amountTypeCap(String word) {
		int type = 0;
		boolean isNull = false;
		for (int i = 0; i < capsule.length && !isNull; i++) {
			if (this.capsule[i] != null && this.capsule[i].getTypeCapsule().equalsIgnoreCase(word)) {
				type++;
			} else {
				isNull = true;
			}
		}
		return type;
	}

	/**
	 * This method stores the lessons in a String variable as long as you already
	 * have capsules registered at the current stage, by traversing the array of
	 * capsules
	 * 
	 * @return the variable that has or does not have the lesions of the capsules
	 */
	public String lessonStage() {
		String msg = "";
		boolean isNull = false;
		for (int i = 0; i < capsule.length && !isNull; i++) {
			if (capsule[i] != null) {
				msg += "\n \nId:" + capsule[i].getId();
				msg += "\tCollaborator: " + capsule[i].getCollaborator();
				msg += "\nLesson: " + capsule[i].getLearning();
			} else {
				if (capsule[0] == null) {
					msg = "The " + getType() + " stage does not have capsule";
				}
				isNull = true;
			}
		}
		return msg;
	}

	/**
	 * Save the planned start date of the stage
	 * 
	 * @param start
	 */
	public void setStart(Calendar start) {
		this.start = start;
	}

	/**
	 * @return the planned start date of the stage
	 */
	public Calendar getStart() {
		return start;
	}

	/**
	 * Saves the final planned date of the stage
	 * 
	 * @param end
	 */
	public void setEnd(Calendar end) {
		this.end = end;
	}

	/**
	 * @return the planned end date of the stage
	 */
	public Calendar getEnd() {
		return end;
	}

	/**
	 * Control method that returns the real start date of a capsule
	 * @return realStard
	 */
	public Calendar getRealStart() {
		return this.realStart;
	}///

	/**
	 * Control method that keeps the actual start date of the capsule
	 * @param realStart capsula real start date
	 */
	public void setRealStart(Calendar realStart) {
		this.realStart = realStart;
	}
	/**
	 * This control method keeps the actual date of ending of the Stage
	 * @param realEnd the actual date of ending of the project
	 */
	public void setRealEnd(Calendar realEnd) {
		this.realEnd = realEnd;
	}

	/**
	 * This control method returns the real date of stage ending
	 * @return
	 */

	public Calendar getRealEnd() {
		return realEnd;
	}

	/**
	 * Returns stage mode
	 * 
	 * @return True: stage on, false: stage off
	 */

	public boolean getMode() {
		return this.mode;
	}

	/**
	 * Save stage mode
	 * 
	 * @param mode True: stage on, false: stage off
	 */
	public void setMode(boolean mode) {
		this.mode = mode;
	}

}