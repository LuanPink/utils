package model;

public class ModelProductMaterial {
	private String id;
	private String nameMeterial;
	
	public ModelProductMaterial() {
		// TODO Auto-generated constructor stub
	}

	public ModelProductMaterial(String nameMeterial) {
		this.nameMeterial = nameMeterial;
	}
	
	public ModelProductMaterial(String id, String nameMeterial) {
		this.id = id;
		this.nameMeterial = nameMeterial;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNameMeterial() {
		return nameMeterial;
	}

	public void setNameMeterial(String nameMeterial) {
		this.nameMeterial = nameMeterial;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nameMeterial;
	}
	
	
	
}
