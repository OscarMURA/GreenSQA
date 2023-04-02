package model;


public class Person {

	private String name;
	private String phone;
	private TypePerson typePerson;


	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	/**
	 * 
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * 
	 * @param typePerson
	 */
	public void setTypePerson(TypePerson typePerson) {
		this.typePerson = typePerson;
	}

	public String getTypePerson() {
		return this.typePerson.getType();
	}


	/**
	 * Builder method of the class Person
	 * @param name
	 * @param phone
	 * @param typePerson
	 */
	public Person(String name, String phone, TypePerson typePerson) {
		this.name=name;
		this.phone=phone;
		this.typePerson=typePerson;
		
	}

}