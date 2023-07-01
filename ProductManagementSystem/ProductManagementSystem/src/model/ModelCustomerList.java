package model;

import javax.swing.Icon;

public class ModelCustomerList {
	private String id;
	private String image;
	private String name;
	private String email;
	private String phone;
	private boolean gender;
	private String buys;
	private double totalMonney;
	private int comment;
	private int likes;
	
	public ModelCustomerList() {
		// TODO Auto-generated constructor stub
	}
	 
	public ModelCustomerList(String id,String name, String email, String phone, String image) {
		this.id = id;
		this.image = image;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public ModelCustomerList(String image, String name, String email, String phone,boolean gender, String buys, double totalMonney,
			int comment, int likes) {
		this.image = image;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.buys = buys;
		this.totalMonney = totalMonney;
		this.comment = comment;
		this.likes = likes;
	}

	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getBuys() {
		return buys;
	}


	public void setBuys(String buys) {
		this.buys = buys;
	}


	public double getTotalMonney() {
		if(totalMonney==0) {
			return 0;
		}
		return totalMonney;
	}


	public void setTotalMonney(double totalMonney) {
		this.totalMonney = totalMonney;
	}

	
	


	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public int getComment() {
		return comment;
	}


	public void setComment(int comment) {
		this.comment = comment;
	}


	public int getLikes() {
		return likes;
	}


	public void setLikes(int likes) {
		this.likes = likes;
	}
	
	
	
	
}
