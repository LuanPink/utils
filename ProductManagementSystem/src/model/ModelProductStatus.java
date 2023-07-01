package model;

public class ModelProductStatus {
	private String nameStatus;
	private boolean status;

	public ModelProductStatus() {
		// TODO Auto-generated constructor stub
	}
	
	public ModelProductStatus(String name) {
		this.nameStatus = name;
	}
	
	public ModelProductStatus(boolean status) {
		this.status = status;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getNameStatus() {
		if(status) {
			return "Đang kinh doanh";
		}
		return "Ngừng kinh doanh";
	}

	public void setNameStatus(String nameStatus) {
		this.nameStatus = nameStatus;
	}

	@Override
	public String toString() {
		return nameStatus;
	}
	
	
	
}
