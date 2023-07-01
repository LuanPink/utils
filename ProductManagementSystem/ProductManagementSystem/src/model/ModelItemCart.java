package model;

public class ModelItemCart {
	private String id;
	private String idCustomer;
	private String img;
	private String idProduct;
	private String productName;
	private String Vat;
	private String size;
	private String color;
	private String material;
	private String type;
	private double price;
	private int quantity;
	private String date;
	
	public ModelItemCart() {
		// TODO Auto-generated constructor stub
	}
	
	public ModelItemCart(String id, String idCustomer, String img,String idProduct, String productName,String vat, String size, String color,
			String material,String type,double price, int quantity, String date) {
		this.id = id;
		this.idCustomer = idCustomer;
		this.img = img;
		this.Vat = vat;
		this.idProduct = idProduct;
		this.productName = productName;
		this.size = size;
		this.color = color;
		this.material = material;
		this.type = type;
		this.price = price;
		this.quantity = quantity;
		this.date = date;
	}

	public ModelItemCart(int quantity,String idCustomer, String idProduct) {
		this.quantity = quantity;
		this.idCustomer = idCustomer;
		this.idProduct = idProduct;
	}

	public String getId() {
		return id;
	}
	public String getVat() {
		return Vat;
	}

	public void setVat(String vat) {
		Vat = vat;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(String idCustomer) {
		this.idCustomer = idCustomer;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getSize() {
		return size;
	}
	
	
	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public String getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}
	
	
}
