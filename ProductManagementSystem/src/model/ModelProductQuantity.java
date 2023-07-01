package model;

public class ModelProductQuantity {
	private int quantity;
	
	public ModelProductQuantity() {
		// TODO Auto-generated constructor stub
	}
	
	public ModelProductQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return quantity + "";
	}
	

}
