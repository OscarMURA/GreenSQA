package model;

/**
 * This person class has the properties such as name, cell phone and if he is a
 * client or manager
 */
public class Person {

	private String name;
	private String phone;
	private String typePerson;

	/**
	 * 
	 * @return The name of the person
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name Save the name of the person
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return the phone's number of the person
	 */
	public String getPhone() {
		return this.phone;
	}

	/**
	 * 
	 * @param phone the save the phone's number of the person
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setTypePerson(String typePerson) {
		this.typePerson = typePerson;
	}

	public String getTypePerson() {
		return this.typePerson;
	}

	/**
	 * Constructor Method of the class Person
	 * @param name
	 * @param phone
	 * @param typePerson
	 */
	public Person(String name, String phone, String typePerson) {
		this.name = name;
		this.phone = phone;
		this.typePerson = typePerson;

	}

}