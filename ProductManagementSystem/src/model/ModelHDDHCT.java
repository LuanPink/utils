package model;

public class ModelHDDHCT {
	private String MaHDDHCT;
	private String MaHDDH;
	private String MaSP;
	private int quantity;
	private String size;
	private String color;
	private String material;
	private double totalPrice;
	
	public ModelHDDHCT() {
		// TODO Auto-generated constructor stub
	}

	public ModelHDDHCT( String maHDDH) {
		MaHDDH = maHDDH;
	}

	public ModelHDDHCT(String maHDDHCT, String maHDDH, String maSP, int quantity, String size, String color,
			String material, double totalPrice) {
		MaHDDHCT = maHDDHCT;
		MaHDDH = maHDDH;
		MaSP = maSP;
		this.quantity = quantity;
		this.size = size;
		this.color = color;
		this.material = material;
		this.totalPrice = totalPrice;
	}

	public String getMaHDDHCT() {
		return MaHDDHCT;
	}

	public void setMaHDDHCT(String maHDDHCT) {
		MaHDDHCT = maHDDHCT;
	}

	public String getMaHDDH() {
		return MaHDDH;
	}

	public void setMaHDDH(String maHDDH) {
		MaHDDH = maHDDH;
	}

	public String getMaSP() {
		return MaSP;
	}

	public void setMaSP(String maSP) {
		MaSP = maSP;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getSize() {
		return size;
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

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}	
}
