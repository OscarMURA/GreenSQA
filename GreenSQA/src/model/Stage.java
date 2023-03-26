package model;
import java.util.Calendar;

public class Stage {

	private TypeStage typeStage;
	private Calendar start;
	private Calendar end;
	private Calendar realStart;
	private Calendar realEnd;
	private boolean mode;
	private Capsule capsule;
	
	public Stage(TypeStage typeStage){
		this.typeStage=typeStage;
		this.mode=false;
		
	}


	public String getType() {
		return this.typeStage.name();
	}

	/**
	 * 
	 * @param typeStage
	 */
	public void setTypeStage(TypeStage typeStage) {
		this.typeStage = typeStage;
	}

	public Calendar getStart() {
		return this.start;
	}

	/**
	 * 
	 * @param start
	 */
	public void setStart(Calendar start) {
		this.start = start;
	}

	public Calendar getEnd() {
		return this.end;
	}

	/**
	 * 
	 * @param end
	 */
	public void setEnd(Calendar end) {
		this.end = end;
	}

	public Calendar getRealStart() {
		return this.realStart;
	}

	/**
	 * 
	 * @param realStart
	 */
	public void setRealStart(Calendar realStart) {
		this.realStart = realStart;
	}

	public Calendar getRealEnd() {
		return this.realEnd;
	}

	/**
	 * 
	 * @param realEnd
	 */
	public void setRealEnd(Calendar realEnd) {
		this.realEnd = realEnd;
	}

	public boolean getMode() {
		return this.mode;
	}

	/**
	 * 
	 * @param mode
	 */
	public void setMode(boolean mode) {
		this.mode = mode;
	}

	public String registerCapsule() {
		// TODO - implement Stage.registerCapsule
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param capsule
	 */
	public void capsuleApprobation(int capsule) {
		// TODO - implement Stage.capsuleApprobation
		throw new UnsupportedOperationException();
	}

}