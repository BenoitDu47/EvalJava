package fr.fms.entities;

/**
 * This class represents an item in an training.
 * 
 * @author ThouryB
 *
 */
public class Training {

	private int idTraining;
	private String trainingName;
	private String description;
	private double price;
	private int category;
	private int duration;
	private boolean distential;
	private int quantity = 1;

	public static final int MAX_STRING_LENGTH = 20;

	/**
	 * Constructs a new training with the specified information.
	 * 
	 * @param idTraining   the ID of the training item
	 * @param trainingName the name of the training item
	 * @param description  the description of the training item
	 * @param price        the price of the training item
	 * @param category     the category of the training item
	 * @param duration     the duration of the training item
	 * @param distential   the availability for distance training of the training
	 *                     item
	 * @param quantity     the quantity of the training item
	 */
	public Training(int idTraining, String trainingName, String description, double price, int category, int duration,
			boolean distential, int quantity) {
		super();
		this.idTraining = idTraining;
		this.trainingName = trainingName;
		this.description = description;
		this.price = price;
		this.category = category;
		this.duration = duration;
		this.distential = distential;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		String distentialTraining;
		if (distential == true) {
			distentialTraining = "Formation en présentielle";
		} else {
			distentialTraining = "Formation en distanciel";
		}
		return centerString(String.valueOf("Formation: " + trainingName))
				+ centerString(String.valueOf(duration) + " semaines") + centerString(String.valueOf(price) + "€")
				+ centerString(distentialTraining);
	}

	public static String centerString(String str) {
		if (str.length() >= MAX_STRING_LENGTH)
			return str;
		String dest = "                    ";
		int deb = (MAX_STRING_LENGTH - str.length()) / 2;
		String data = new StringBuilder(dest).replace(deb, deb + str.length(), str).toString();
		return data;
	}

	public int getIdTraining() {
		return idTraining;
	}

	public void setIdTraining(int idTraining) {
		this.idTraining = idTraining;
	}

	public String getTrainingName() {
		return trainingName;
	}

	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public boolean isDistential() {
		return distential;
	}

	public void setDistential(boolean distential) {
		this.distential = distential;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
