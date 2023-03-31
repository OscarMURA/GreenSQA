package model;

import java.util.Calendar;

public class Stage {

	private TypeStage typeStage;
	private Calendar start; 
	private Calendar end;
	private Calendar realStart;
	private Calendar realEnd;
	private boolean mode=false;
	private Capsule capsule[] = new Capsule[50];
	private int capCouter = 0;

	public Stage(TypeStage typeStage) {
		this.typeStage = typeStage;
		
	}

	public Capsule getCapsule(int i) {
		return capsule[i];
	}

	public String addCapsule(Capsule capsule) {

		String register = "The capsule was not registered successfully, no space to add\n";

		if (capCouter != this.capsule.length) {

			this.capsule[capCouter++] = capsule;
			register = "The capsule was registered successfully\n";
		}

		return register;
	}

	public String getType() {
		return this.typeStage.getType();
	}

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

	public Capsule searchCapsule(String id) {
		boolean isFound = false;
		Capsule capsule = null;

		for (int i = 0; i < this.capsule.length && !isFound; i++) {

			if(this.capsule[i]!=null && this.capsule[i].getId().equalsIgnoreCase(id)){
				capsule = this.capsule[i];
				isFound = true;
				
			}
			
		}
		return capsule;
	}

	public void setStart(Calendar start) {
		this.start = start;
	}

	public Calendar getStart() {
		return start;
	}

	public void setEnd(Calendar end) {
		this.end = end;
	}
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

	public boolean getMode() {
		return this.mode;
	}

	public void setMode(boolean mode) {
		this.mode = mode;
	}

}