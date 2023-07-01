package model;

public class ModelHDTH {
	private String MaHDTraHang;
	private String NgayTra;
	private double totalPrice;
	private String note;
	private String MaKH;
	private String name;
	private String phone;
	

	public ModelHDTH() {
		// TODO Auto-generated constructor stub
	}
	
	public ModelHDTH(String maHDTraHang) {
		MaHDTraHang = maHDTraHang;
	}

	public ModelHDTH(String maHDTraHang, String ngayTra, double totalPrice, String note, String maKH) {
		MaHDTraHang = maHDTraHang;
		NgayTra = ngayTra;
		this.totalPrice = totalPrice;
		this.note = note;
		MaKH = maKH;
	}
	
	public ModelHDTH(String maHDTraHang, String ngayTra, double totalPrice, String note, String maKH, String name, String phone) {
		MaHDTraHang = maHDTraHang;
		NgayTra = ngayTra;
		this.totalPrice = totalPrice;
		this.note = note;
		MaKH = maKH;
		this.name= name;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMaHDTraHang() {
		return MaHDTraHang;
	}

	public void setMaHDTraHang(String maHDTraHang) {
		MaHDTraHang = maHDTraHang;
	}

	public String getNgayTra() {
		return NgayTra;
	}

	public void setNgayTra(String ngayTra) {
		NgayTra = ngayTra;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getMaKH() {
		return MaKH;
	}

	public void setMaKH(String maKH) {
		MaKH = maKH;
	}
	
	
	
}
