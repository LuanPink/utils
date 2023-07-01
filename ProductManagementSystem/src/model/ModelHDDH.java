package model;

public class ModelHDDH {
	private String MaHDDH;
	private String NgayDoi;
	private double total;
	private String MaKH;
	
	public ModelHDDH() {
		// TODO Auto-generated constructor stub
	}
	
	public ModelHDDH(String maHDDH) {
		MaHDDH = maHDDH;
	}

	public ModelHDDH(String maHDDH, String ngayDoi, double total, String maKH) {
		MaHDDH = maHDDH;
		NgayDoi = ngayDoi;
		this.total = total;
		MaKH = maKH;
	}

	public String getMaHDDH() {
		return MaHDDH;
	}

	public void setMaHDDH(String maHDDH) {
		MaHDDH = maHDDH;
	}

	public String getNgayDoi() {
		return NgayDoi;
	}

	public void setNgayDoi(String ngayDoi) {
		NgayDoi = ngayDoi;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getMaKH() {
		return MaKH;
	}

	public void setMaKH(String maKH) {
		MaKH = maKH;
	}
	
	
	
	
}
