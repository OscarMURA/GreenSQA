package model;
import java.util.Date;
public class Stage {

	private TypeStage typeStage;
	private Date start;
	private Date end;
	private Date realStart;
	private Date realEnd;
	private String mode;
	private Capsule capsule;

	public TypeStage getTypeStage() {
		return this.typeStage;
	}

	/**
	 * 
	 * @param typeStage
	 */
	public void setTypeStage(TypeStage typeStage) {
		this.typeStage = typeStage;
	}

	public Date getStart() {
		return this.start;
	}

	/**
	 * 
	 * @param start
	 */
	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return this.end;
	}

	/**
	 * 
	 * @param end
	 */
	public void setEnd(Date end) {
		this.end = end;
	}

	public Date getRealStart() {
		return this.realStart;
	}

	/**
	 * 
	 * @param realStart
	 */
	public void setRealStart(Date realStart) {
		this.realStart = realStart;
	}

	public Date getRealEnd() {
		return this.realEnd;
	}

	/**
	 * 
	 * @param realEnd
	 */
	public void setRealEnd(Date realEnd) {
		this.realEnd = realEnd;
	}

	public String getMode() {
		return this.mode;
	}

	/**
	 * 
	 * @param mode
	 */
	public void setMode(String mode) {
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