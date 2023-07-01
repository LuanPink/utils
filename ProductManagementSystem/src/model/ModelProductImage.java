package model;

public class ModelProductImage {
	private String productImage;
	
	public ModelProductImage() {
		// TODO Auto-generated constructor stub
	}
	public ModelProductImage(String productImage) {
		this.productImage = productImage;
	}
	
	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}


	@Override
	public String toString() {
		return productImage;
	}
	
	
}
