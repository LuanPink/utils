package model;

public class ModelProductType {
	private String id;
	private String nameType;
	private String describer;
	
	public ModelProductType() {
		// TODO Auto-generated constructor stub
	}

	public ModelProductType(String nameType) {
		this.nameType = nameType;
	}
	
	public ModelProductType(String id, String nameType) {
		this.id = id;
		this.nameType = nameType;
	}

	public ModelProductType(String id, String nameType, String describer) {
		this.id = id;
		this.nameType = nameType;
		this.describer = describer;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNameType() {
		return nameType;
	}


	public void setNameType(String nameType) {
		this.nameType = nameType;
	}


	public String getDescriber() {
		return describer;
	}


	public void setDescriber(String describer) {
		this.describer = describer;
	}


	@Override
	public String toString() {
		return nameType;
	}
	
	
	
}	
