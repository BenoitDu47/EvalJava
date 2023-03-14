package fr.fms.authentication;

import fr.fms.dao.CustomerDao;
import fr.fms.dao.Dao;
import fr.fms.dao.DaoFactory;
import fr.fms.dao.UserDao;
import fr.fms.entities.Customer;
import fr.fms.entities.User;

public class Authenticate {
	private Dao<Customer> customerDao = DaoFactory.getCustomerDao();
	private Dao<User> userDao = DaoFactory.getUserDao();

	/**
	 * Checks if a user with the given credentials exists in the database.
	 * 
	 * @param log the user's login
	 * @param pwd the user's password
	 * @return the user's ID if they exist, otherwise 0
	 */
	public int existUser(String log, String pwd) {
		User user = ((UserDao) userDao).findUserByCredentials(log, pwd);
		if (user != null)
			return user.getId();
		return 0;
	}

	/**
	 * Checks if a user with the given login exists in the database.
	 * 
	 * @param log the user's login
	 * @return the user's ID if they exist, otherwise 0
	 */
	public int existUser(String log) {
		User user = ((UserDao) userDao).findUserByLogin(log);
		if (user != null)
			return user.getId();
		return 0;
	}

	/**
	 * Finds a customer in the database using their email.
	 * 
	 * @param email the customer's email
	 * @return the Customer object if they exist, otherwise null
	 */
	public Customer existCustomerByEmail(String email) {
		return ((CustomerDao) customerDao).findCustomerByEmail(email);
	}

	/**
	 * Adds a new user to the database with the given email and password.
	 * 
	 * @param email    the user's email
	 * @param password the user's password
	 */
	public void addUser(String email, String password) {
		userDao.create(new User(0, email, password, false));
	}

	/**
	 * Adds a new customer to the database.
	 * 
	 * @param customer the Customer object to be added
	 * @return true if the customer was successfully added, otherwise false
	 */
	public boolean addCustomer(Customer customer) {
		return customerDao.create(customer);
	}
}
