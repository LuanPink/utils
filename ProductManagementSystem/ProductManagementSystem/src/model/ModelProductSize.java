package model;

public class ModelProductSize {
	private String id;
	private String nameSize;
	
	public ModelProductSize() {
		// TODO Auto-generated constructor stub
	}

	public ModelProductSize( String nameSize) {
		this.nameSize = nameSize;
	}

	public ModelProductSize(String id, String nameSize) {
		this.id = id;
		this.nameSize = nameSize;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNameSize() {
		return nameSize;
	}

	public void setNameSize(String nameSize) {
		this.nameSize = nameSize;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nameSize;
	}
	
	
}
