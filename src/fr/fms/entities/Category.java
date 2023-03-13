package fr.fms.entities;

/**
 * This class represents a Category of Training.
 * 
 * @author ThouryB
 *
 */
public class Category {

	private int idCategory;
	private String name;
	private String description;

	/**
	 * Constructs a new Category with the specified information.
	 * 
	 * @param id          The Id category
	 * @param name        The Category name
	 * @param description The Description category
	 */
	public Category(int idCategory, String name, String description) {
		super();
		this.idCategory = idCategory;
		this.name = name;
		this.description = description;
	}

	@Override
	public String toString() {
		return centerString(String.valueOf(idCategory)) + centerString(name) + centerString(description);
	}

	/**
	 * Centers the given string in a column of width 20. If the length of the string
	 * is greater than or equal to 20, the string is returned unchanged.
	 * 
	 * @param str The string to center.
	 * @return The centered string.
	 */
	public static String centerString(String str) {
		if (str.length() >= 20)
			return str;
		String dest = "                                        ";
		int deb = (20 - str.length()) / 2;
		String data = new StringBuilder(dest).replace(deb, deb + str.length(), str).toString();
		return data;
	}

	public int getId() {
		return idCategory;
	}

	public void setId(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
