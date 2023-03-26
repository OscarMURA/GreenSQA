package model;

public enum TypeCapsule {
	

	 Tecnic("Tecnic"),
	 Manage("Manage"),
	 Domain("Domain"),
	 Experience("Experience");

	public final String type;

	TypeCapsule(String type){
		this.type=type;
	}

	public String getType(){
		return type;
	}

}