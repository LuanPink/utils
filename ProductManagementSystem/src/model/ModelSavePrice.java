package model;

public class ModelSavePrice {
	 	private String name;
	    private int price;
	    private int quantity;
	    private boolean isChecked;

	    public ModelSavePrice(String name, int price, int quantity) {
	        this.name = name;
	        this.price = price;
	        this.quantity = quantity;
	        this.isChecked = false;
	    }

	    public String getName() {
	        return name;
	    }

	    public int getPrice() {
	        return price;
	    }

	    public int getQuantity() {
	        return quantity;
	    }

	    public boolean isChecked() {
	        return isChecked;
	    }

	    public void setChecked(boolean isChecked) {
	        this.isChecked = isChecked;
	    }
	

	
	public ModelSavePrice() {
		// TODO Auto-generated constructor stub
	}
}
