package fr.fms.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Logger;

import fr.fms.entities.Training;

/**
 * The Dao interface provides methods to perform CRUD (Create, Read, Update,
 * Delete) operations on a database.
 *
 * @author ThouryB
 *
 * @param <T> the type of the object that this DAO works with.
 */
public interface Dao<T> {

	/**
	 * The database connection.
	 */
	public static Connection connection = BddConnection.getConnection();

	/**
	 * The logger for this class.
	 */
	public static final Logger logger = Logger.getLogger(Dao.class.getName());

	/**
	 * Creates a new record in the database for the specified object.
	 * 
	 * @param obj the object to create a record for.
	 * @return true if the record was successfully created, false otherwise.
	 */
	public boolean create(T obj);

	/**
	 * Retrieves the record for the specified ID from the database.
	 * 
	 * @param id the ID of the record to retrieve.
	 * @return the object representing the retrieved record, or null if the record
	 *         was not found.
	 */
	public T read(int id);

	/**
	 * Updates the record in the database for the specified object.
	 * 
	 * @param obj the object to update the record for.
	 * @return true if the record was successfully updated, false otherwise.
	 */
	public boolean update(T obj);

	/**
	 * Deletes the record in the database for the specified object.
	 * 
	 * @param obj the object to delete the record for.
	 * @return true if the record was successfully deleted, false otherwise.
	 */
	public boolean delete(T obj);

	/**
	 * Retrieves all records for the specified object from the database.
	 * 
	 * @return an ArrayList of objects representing the retrieved records.
	 */
	public ArrayList<T> readAll();

	public Training readbyString(String weyword);
}
