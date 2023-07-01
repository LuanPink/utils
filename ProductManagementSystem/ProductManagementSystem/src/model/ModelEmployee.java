package model;

public class ModelEmployee {
	private String idEmployee;
	private String name;
	private String chucVu;
	private boolean gender;
	private String ngaySinh;
	private String addRess;
	private String phone;
	private String email;
	private double salary;
	
	public ModelEmployee() {
		// TODO Auto-generated constructor stub
	}
	
	public ModelEmployee(String name) {
		this.name = name;
	}
	
	public ModelEmployee(String idEmployee, String name, String chucVu,boolean gender, String ngaySinh, String addRess, String phone,
			String email, double salary) {
		this.idEmployee = idEmployee;
		this.name = name;
		this.chucVu = chucVu;
		this.gender = gender;
		this.ngaySinh = ngaySinh;
		this.addRess = addRess;
		this.phone = phone;
		this.email = email;
		this.salary = salary;
	}
	
	
	
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public String getIdEmployee() {
		return idEmployee;
	}
	public void setIdEmployee(String idEmployee) {
		this.idEmployee = idEmployee;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getAddRess() {
		return addRess;
	}
	public void setAddRess(String addRess) {
		this.addRess = addRess;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	
}
