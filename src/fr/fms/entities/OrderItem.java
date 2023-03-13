package fr.fms.entities;

/**
 * This class represents an item in an order.
 * 
 * @author ThouryB
 *
 */
public class OrderItem {

	private int idOrderItem;
	private int idTraining;
	private int quantity;
	private double unitaryPrice;
	private int idOrder;

	/**
	 * Constructs a new order item with the specified parameters.
	 * 
	 * @param idOrderItem  The ID of the order item.
	 * @param idTraining   The ID of the training associated with the order item.
	 * @param quantity     The quantity of the article ordered.
	 * @param unitaryPrice The unitary price of the article ordered.
	 * @param idOrder      The ID of the order to which the item belongs.
	 */
	public OrderItem(int idOrderItem, int idTraining, int quantity, double unitaryPrice, int idOrder) {
		super();
		this.idOrderItem = idOrderItem;
		this.idTraining = idTraining;
		this.quantity = quantity;
		this.unitaryPrice = unitaryPrice;
		this.idOrder = idOrder;
	}

	@Override
	public String toString() {
		return "OrderItem [idOrderItem=" + idOrderItem + ", idTraining=" + idTraining + ", quantity=" + quantity
				+ ", unitaryPrice=" + unitaryPrice + ", idOrder=" + idOrder + "]";
	}

	public int getIdOrderItem() {
		return idOrderItem;
	}

	public void setIdOrderItem(int idOrderItem) {
		this.idOrderItem = idOrderItem;
	}

	public int getIdTraining() {
		return idTraining;
	}

	public void setIdTraining(int idTraining) {
		this.idTraining = idTraining;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getUnitaryPrice() {
		return unitaryPrice;
	}

	public void setUnitaryPrice(double unitaryPrice) {
		this.unitaryPrice = unitaryPrice;
	}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}
}
