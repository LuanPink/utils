package model;

public class ModelHDBHCT {
	private String id;
	private String MaHDBH;
	private String MaKH;
	private String TenKH;
	private String MaSP;
	private String TenSP;
	private int quantity;
	private double totalPrice;
	private String size;
	private String color;
	private String material;
	private String type;
	private int indexRow;
	public ModelHDBHCT() {
		// TODO Auto-generated constructor stub
	}

	public ModelHDBHCT(String id, String maHDBH, String maKH, String tenKH, String maSP, String tenSP, int quantity,
			double totalPrice, String size, String color, String material, String type,int indexRow) {
		this.id = id;
		MaHDBH = maHDBH;
		MaKH = maKH;
		TenKH = tenKH;
		MaSP = maSP;
		TenSP = tenSP;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.size = size;
		this.color = color;
		this.material = material;
		this.type = type;
		this.indexRow = indexRow;
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



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMaHDBH() {
		return MaHDBH;
	}

	public void setMaHDBH(String maHDBH) {
		MaHDBH = maHDBH;
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

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public int getIndexRow() {
		return indexRow;
	}

	public void setIndexRow(int indexRow) {
		this.indexRow = indexRow;
	}

	public ModelHDBHCT(String id, String maHDBH, String maSP, int quantity, double totalPrice, String size,
			String color, String material, String type) {
		this.id = id;
		MaHDBH = maHDBH;
		MaSP = maSP;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.size = size;
		this.color = color;
		this.material = material;
		this.type = type;
	}
	
	public ModelHDBHCT(String maHDBH) {
		this.MaHDBH = maHDBH;
		
	}
	
	
}
