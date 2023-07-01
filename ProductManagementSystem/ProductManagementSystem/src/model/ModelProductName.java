package model;

public class ModelProductName {
	private String productName;
	
	public ModelProductName() {
		// TODO Auto-generated constructor stub
	}

	public ModelProductName(String productName) {
		this.productName = productName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return productName;
	}
	
	
	
}
