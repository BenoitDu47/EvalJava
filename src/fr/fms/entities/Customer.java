package fr.fms.entities;

/**
 * This class represents a customer.
 * 
 * @author ThouryB
 *
 */
public class Customer {

	private int idCustomer;
	private String lastName;
	private String firstName;
	private String email;
	private String phone;
	private String address;
	private int idUser;

	/**
	 * Constructs a new customer item with the specified parameters.
	 * 
	 * @param idCustomer the ID of the customer
	 * @param lastName   the last name of the customer
	 * @param firstName  the first name of the customer
	 * @param email      the email of the customer
	 * @param phone      the phone number of the customer
	 * @param address    the address of the customer
	 * @param idUser     the ID of the user associated with the customer
	 */
	public Customer(int idCustomer, String lastName, String firstName, String email, String phone, String address,
			int idUser) {
		super();
		this.idCustomer = idCustomer;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.idUser = idUser;
	}

	public Customer(String lastName, String firstName, String email, String phone, String address, int idUser) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.idUser = idUser;
	}

	public Customer(String lastName, String firstName, String email, String phone, String address) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	@Override
	public String toString() {
		return "\n Nom = " + lastName + ", Prénom = " + firstName + "\n Email = " + email + ", Téléphone = " + phone
				+ "\n Address = " + address;
	}

	public int getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

}
