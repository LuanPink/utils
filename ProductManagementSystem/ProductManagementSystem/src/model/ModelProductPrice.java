package model;

public class ModelProductPrice {
	private double price;

	public ModelProductPrice() {
		// TODO Auto-generated constructor stub
	}

	public ModelProductPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		long roundValue = Math.round(price);
		return roundValue + "";
	}

}
