package model;

public class ModelProductWarranty {
	private String warranty;
	
	public ModelProductWarranty() {
		// TODO Auto-generated constructor stub
	}

	public ModelProductWarranty(String warranty) {
		this.warranty = warranty;
	}

	public String getWarranty() {
		return warranty;
	}

	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}

	@Override
	public String toString() {
		return warranty;
	}
	
	
}
