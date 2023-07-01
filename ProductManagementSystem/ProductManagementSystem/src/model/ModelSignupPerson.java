package model;

public class ModelSignupPerson {
	private String tentaikhoan;
	private String matkhau;
	private String email;
	private String sdt;
	public ModelSignupPerson(String tentaikhoan, String matkhau, String email, String sdt) {
		this.tentaikhoan = tentaikhoan;
		this.matkhau = matkhau;
		this.email = email;
		this.sdt = sdt;
	}
	public ModelSignupPerson() {
		
	}
	public String getTentaikhoan() {
		return tentaikhoan;
	}
	public void setTentaikhoan(String tentaikhoan) {
		this.tentaikhoan = tentaikhoan;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	
	
}
