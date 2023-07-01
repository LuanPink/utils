package model;

public class ModelProductColor {
	private String id;
	private String nameColor;
	
	public ModelProductColor() {
		// TODO Auto-generated constructor stub
	}

	public ModelProductColor(String nameColor) {
		this.nameColor = nameColor;
	}

	public ModelProductColor(String id, String nameColor) {
		this.id = id;
		this.nameColor = nameColor;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNameColor() {
		return nameColor;
	}


	public void setNameColor(String nameColor) {
		this.nameColor = nameColor;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nameColor;
	}
	
	
	
}
