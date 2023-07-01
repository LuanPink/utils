package model;

public class ModelProductId {
	private String id;
	
	public ModelProductId() {
		// TODO Auto-generated constructor stub
	}

	public ModelProductId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return id;
	}
	
}
