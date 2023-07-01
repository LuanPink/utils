package model;

public class ModelProductVAT {
	private String vat;
	
	public ModelProductVAT() {
		// TODO Auto-generated constructor stub
	}

	public ModelProductVAT(String vat) {
		this.vat = vat;
	}

	public String getVat() {
		return vat;
	}

	public void setVat(String vat) {
		this.vat = vat;
	}

	@Override
	public String toString() {
		double valueFirst = Double.parseDouble(vat);
		long roundValue = Math.round(valueFirst);
		return roundValue+"";
	}
	
	
}
