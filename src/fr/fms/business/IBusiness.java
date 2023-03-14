package fr.fms.business;

import java.util.ArrayList;

import fr.fms.entities.Category;
import fr.fms.entities.Training;

/**
 * The IBusiness interface defines the methods that a business layer
 * implementation must provide in order to interact with the application's data
 * layer.
 * 
 * @author ThouryB
 *
 */
public interface IBusiness {

	/**
	 * Adds a training to the cart.
	 * 
	 * @param training the training to add to the cart
	 */
	public void addToCart(Training training);

	/**
	 * Removes a training from the cart.
	 * 
	 * @param id the ID of the training to remove from the cart
	 */
	public void rmFromCart(int id);

	/**
	 * Returns the contents of the cart.
	 * 
	 * @return an ArrayList of Training objects representing the contents of the
	 *         cart
	 */
	public ArrayList<Training> getCart();

	/**
	 * Places an order for the contents of the cart.
	 * 
	 * @param idUser the ID of the user placing the order
	 * @return an int representing the order ID
	 */
	public int order(int idUser);

	/**
	 * Returns an ArrayList of all Training objects in the application.
	 * 
	 * @return an ArrayList of all Training objects in the application
	 */
	public ArrayList<Training> readTrainings();

	/**
	 * Returns a specific Training object based on the provided ID.
	 * 
	 * @param id the ID of the Training object to retrieve
	 * @return a Training object corresponding to the provided ID, or null if no
	 *         Training was found
	 */
	public Training readOneTraining(int id);

	/**
	 * Returns an ArrayList of all Category objects in the application.
	 * 
	 * @return an ArrayList of all Category objects in the application
	 */
	public ArrayList<Category> readCategories();

	/**
	 * Returns an ArrayList of Training objects corresponding to the provided
	 * category ID.
	 * 
	 * @param idCat the ID of the category for which to retrieve Training objects
	 * @return an ArrayList of Training objects corresponding to the provided
	 *         category ID
	 */
	public ArrayList<Training> readTrainingsByCatId(int idCat);
}
