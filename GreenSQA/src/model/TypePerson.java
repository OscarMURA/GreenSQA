
package model;

public enum TypePerson {
	 Manager("Project Manager "),
	 Costumer("Project Costumer");

	 private final String type;

	 TypePerson(String type){
		this.type=type;
	 }

	 public String getType(){
		return type;
	 }

}