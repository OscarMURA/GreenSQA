package model;

import java.util.Calendar;

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
	 * the method of finding capsules
	 * 
	 * @param id
	 * @return true: the capsule was approved, false: the capsule did not exist and
	 *         was not approved
	 */
	public boolean capsuleApproval(String id) {

		Calendar aprobationDate = Calendar.getInstance();
		boolean aprobation = false;

		if (searchCapsule(id) != (null)) {

			searchCapsule(id).setAprobation(true);
			searchCapsule(id).setAprobationDate(aprobationDate);
			aprobation = true;

		}

		return aprobation;
	}

	/**
	 * Search for a capsule object by its id
	 * 
	 * @param id
	 * @return returns a capsule object, but if it is different from null it means
	 *         that it found the capsule
	 */
	public Capsule searchCapsule(String id) {
		boolean isFound = false;
		Capsule capsule = null;

		for (int i = 0; i < this.capsule.length && !isFound; i++) {

			if (this.capsule[i] != null && this.capsule[i].getId().equalsIgnoreCase(id)) {
				capsule = this.capsule[i];
				isFound = true;

			}

		}
		return capsule;
	}

	/**
	 * Save the planned start date of the stage
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

	public Calendar getRealStart() {
		return this.realStart;
	}

	public void setRealStart(Calendar realStart) {
		this.realStart = realStart;
	}

	public void setRealEnd(Calendar realEnd) {
		this.realEnd = realEnd;
	}

	public Calendar getRealEnd() {
		return realEnd;
	}

	/**
	 * Returns stage mode
	 * @return True: stage on, false: stage off
	 */

	public boolean getMode() {
		return this.mode;
	}

	/**
	 * Save stage mode
	 * @param mode True: stage on, false: stage off
	 */
	public void setMode(boolean mode) {
		this.mode = mode;
	}

}