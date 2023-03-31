package model;

public enum TypeStage {
	
	 Start("Start"),
	 Analysis("Analysis"),
	 Design("Design"),
	 Execution("Execution"),
	 Clouse("Clouse"),
	 MonitoringAndControl("Monitoring and project control");

	 public final String type;

	TypeStage(String type){
		this.type=type;
	}

	public String getType(){
		return type;
	}

}