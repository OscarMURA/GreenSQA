package model;

/**
  * Enumeration of the types of stages
  */
public enum TypeStage {

	Start("Start"),
	Analysis("Analysis"),
	Design("Design"),
	Execution("Execution"),
	Clouse("Clouse"),
	MonitoringAndControl("Monitoring and project control");

	/**
	 * The name of the stage.
	 */
	public final String type;

	/**
	 * 
	 * Constructor for TypeStage.
	 * 
	 * @param type the name of the stage
	 */
	TypeStage(String type) {
		this.type = type;
	}

	/**
	 * Returns the name of the stage.
	 * @return the name of the stage
	 */
	public String getType() {
		return type;
	}
}
