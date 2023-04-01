package model;

public enum TypeCapsule {

	// Possible types of capsules
	Tecnic("Technical"),
	Manage("Management"),
	Domain("Domain-specific"),
	Experience("Experience-based");

	// Type of the capsule
	public final String type;

	/**
	 * Constructor for the enumeration.
	 * @param type The type of the capsule.
	 */
	TypeCapsule(String type) {
		this.type = type;
	}

	/**
	 * Returns the type of the capsule.
	 * @return The type of the capsule.
	 */
	public String getType() {
		return type;
	}

}