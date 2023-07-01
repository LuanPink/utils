package model;

public class ModelHDBH {
	private String MaHDBH;
	private String MaKH;
	private String MaNV;
	private String nameKH;
	private String nameNV;
	private String phone;
	private String ngayBan;
	private double tolalPrice;

	public ModelHDBH() {

	}

	public ModelHDBH(String maHDBH) {
		this.MaHDBH = maHDBH;
	}

	public ModelHDBH(String maHDBH, String maKH, String maNV, String ngayBan, double tolalPrice) {
		this.MaHDBH = maHDBH;
		this.MaKH = maKH;
		this.MaNV = maNV;
		this.ngayBan = ngayBan;
		this.tolalPrice = tolalPrice;
	}

	public ModelHDBH(String maHDBH, String maKH, String maNV, String nameKH, String nameNV, String phone,
			String ngayBan, double tolalPrice) {
		MaHDBH = maHDBH;
		MaKH = maKH;
		MaNV = maNV;
		this.nameKH = nameKH;
		this.nameNV = nameNV;
		this.phone = phone;
		this.ngayBan = ngayBan;
		this.tolalPrice = tolalPrice;
	}

	public String getNameKH() {
		return nameKH;
	}

	public void setNameKH(String nameKH) {
		this.nameKH = nameKH;
	}

	public String getNameNV() {
		return nameNV;
	}

	public void setNameNV(String nameNV) {
		this.nameNV = nameNV;
	}

	public String getMaHDBH() {
		return MaHDBH;
	}

	public void setMaHDBH(String maHDBH) {
		MaHDBH = maHDBH;
	}

	public String getMaKH() {
		return MaKH;
	}

	public void setMaKH(String maKH) {
		MaKH = maKH;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMaNV() {
		return MaNV;
	}

	public void setMaNV(String maNV) {
		MaNV = maNV;
	}

	public String getNgayBan() {
		return ngayBan;
	}

	public void setNgayBan(String ngayBan) {
		this.ngayBan = ngayBan;
	}

	public double getTolalPrice() {
		return tolalPrice;
	}

	public void setTolalPrice(double tolalPrice) {
		this.tolalPrice = tolalPrice;
	}

}
