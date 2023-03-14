package fr.fms.dao;

import fr.fms.entities.Category;
import fr.fms.entities.Customer;
import fr.fms.entities.Order;
import fr.fms.entities.OrderItem;
import fr.fms.entities.Training;
import fr.fms.entities.User;

/**
 * The DaoFactory class provides static methods to create DAO objects for
 * different entities. Each method returns an instance of a DAO object for the
 * corresponding entity.
 * 
 * @author ThouryB
 *
 */
public class DaoFactory {

	/**
	 * Creates a new TrainingDao object.
	 * 
	 * @return a new TrainingDao object.
	 */
	public static Dao<Training> getTrainingDao() {
		return new TrainingDao();
	}

	/**
	 * Creates a new UserDao object.
	 * 
	 * @return a new UserDao object.
	 */
	public static Dao<User> getUserDao() {
		return new UserDao();
	}

	/**
	 * Creates a new CategoryDao object.
	 * 
	 * @return a new CategoryDao object.
	 */
	public static Dao<Category> getCategoryDao() {
		return new CategoryDao();
	}

	/**
	 * Creates a new OrderDao object.
	 * 
	 * @return a new OrderDao object.
	 */
	public static Dao<Order> getOrderDao() {
		return new OrderDao();
	}

	/**
	 * Creates a new OrderItemDao object.
	 * 
	 * @return a new OrderItemDao object.
	 */
	public static Dao<OrderItem> getOrderItemDao() {
		return new OrderItemDao();
	}

	/**
	 * Creates a new CustomerDao object.
	 * 
	 * @return a new CustomerDao object.
	 */
	public static Dao<Customer> getCustomerDao() {
		return new CustomerDao();
	}
}