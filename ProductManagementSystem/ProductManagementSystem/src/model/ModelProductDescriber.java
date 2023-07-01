package model;

public class ModelProductDescriber {
	private String describer;
	
	public ModelProductDescriber() {
		// TODO Auto-generated constructor stub
	}

	public ModelProductDescriber(String describer) {
		this.describer = describer;
	}
	
	public String getDescriber() {
		return describer;
	}
	
	public void setDescriber(String describer) {
		this.describer = describer;
	}
	
	@Override
	public String toString() {
		return describer;
	}
}

