package model;

public class ModelHDTHCT {
	private String MaHDTHCT;
	private String MaHDTH;
	private String MaKH;
	private String TenKH;
	private String MaSP;
	private String TenSP;
	private int quantity;
	private String size;
	private String color;
	private String material;
	private double totalPrice;
	
	public ModelHDTHCT() {
		// TODO Auto-generated constructor stub
	}
	
	public ModelHDTHCT(String maHDTH) {
		this.MaHDTH = maHDTH;
	}

	public ModelHDTHCT(String maHDTHCT, String maHDTH, String maSP, int quantity, String size, String color,
			String material, double totalPrice) {
		MaHDTHCT = maHDTHCT;
		MaHDTH = maHDTH;
		MaSP = maSP;
		this.quantity = quantity;
		this.size = size;
		this.color = color;
		this.material = material;
		this.totalPrice = totalPrice;
	}
	
	public ModelHDTHCT(String maHDTHCT, String maHDTH, String maKH, String tenKH, String maSP, String tenSP,
			int quantity, String size, String color, String material, double totalPrice) {
		MaHDTHCT = maHDTHCT;
		MaHDTH = maHDTH;
		MaKH = maKH;
		TenKH = tenKH;
		MaSP = maSP;
		TenSP = tenSP;
		this.quantity = quantity;
		this.size = size;
		this.color = color;
		this.material = material;
		this.totalPrice = totalPrice;
	}

	public String getMaKH() {
		return MaKH;
	}

	public void setMaKH(String maKH) {
		MaKH = maKH;
	}

	public String getTenKH() {
		return TenKH;
	}

	public void setTenKH(String tenKH) {
		TenKH = tenKH;
	}

	public String getTenSP() {
		return TenSP;
	}

	public void setTenSP(String tenSP) {
		TenSP = tenSP;
	}

	public String getMaHDTHCT() {
		return MaHDTHCT;
	}

	public void setMaHDTHCT(String maHDTHCT) {
		MaHDTHCT = maHDTHCT;
	}

	public String getMaHDTH() {
		return MaHDTH;
	}

	public void setMaHDTH(String maHDTH) {
		MaHDTH = maHDTH;
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
