package model;

public class ModelDoanhThu {
	private int month;
	private long spBan;
	private long totalPrice;
	private long totalNhapHang;
	private long loiNhuan;
	
	
	public ModelDoanhThu() {
		// TODO Auto-generated constructor stub
	}

	public ModelDoanhThu(int month, long spBan, long totalPrice,long totalNhapHang, long loiNhuan) {
		this.month = month;
		this.spBan = spBan;
		this.totalPrice = totalPrice;
		this.totalNhapHang =totalNhapHang;
		this.loiNhuan = loiNhuan;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public long getTotalNhapHang() {
		return totalNhapHang;
	}

	public void setTotalNhapHang(long totalNhapHang) {
		this.totalNhapHang = totalNhapHang;
	}

	public long getSpBan() {
		return spBan;
	}

	public void setSpBan(long spBan) {
		this.spBan = spBan;
	}

	public long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public long getLoiNhuan() {
		return loiNhuan;
	}

	public void setLoiNhuan(long loiNhuan) {
		this.loiNhuan = loiNhuan;
	}
	
	
}
