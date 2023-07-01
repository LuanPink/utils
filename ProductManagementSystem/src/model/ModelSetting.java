package model;

public class ModelSetting {
	String ten;
	String email;
	String sdt;
	String pass;
	public ModelSetting() {
		
	}
	public ModelSetting(String ten, String email, String sdt, String pass) {
		this.ten = ten;
		this.email = email;
		this.sdt = sdt;
		this.pass = pass;
	}
	public String getTen() {
		return ten;
	}
	public String getEmail() {
		return email;
	}
	public String getSdt() {
		return sdt;
	}
	public String getPass() {
		return pass;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
	
}
