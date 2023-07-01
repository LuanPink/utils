package model;

import java.util.Objects;

import com.raven.table.model.TableRowData;

public class ModelProduct extends TableRowData{

	private ModelProductId id;
	private ModelProductName productName;
	private ModelProductPrice price;
	private ModelProductQuantity quantity;
	private ModelProductWarranty warranty;
	private ModelProductVAT vat;
	private ModelProductDescriber describer;
	private ModelProductImage productImage;
	private ModelProductStatus status;
	private ModelSupplier supplier;
	private ModelProductType productType;
	private ModelProductSize productSize;
	private ModelProductColor productColor;
	private ModelProductMaterial productMaterial;
	
	@Override
	public Object[] toTableRow() {		
		return new Object[] {id,productName,price,quantity,warranty,vat,productImage,describer,status,supplier,productType,productSize,productColor,productMaterial};
	}
	
	public ModelProduct() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ModelProduct(ModelProductId id, ModelProductName productName, ModelProductPrice price, ModelProductQuantity quantity,
			ModelProductWarranty warranty, ModelProductVAT vat, ModelProductDescriber describer, ModelProductImage productImage,
			ModelProductStatus status, ModelSupplier supplier, ModelProductType productType,
			ModelProductSize productSize, ModelProductColor productColor, ModelProductMaterial productMaterial) {
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.warranty = warranty;
		this.vat = vat;
		this.describer = describer;
		this.productImage = productImage;
		this.status = status;
		this.supplier = supplier;
		this.productType = productType;
		this.productSize = productSize;
		this.productColor = productColor;
		this.productMaterial = productMaterial;
	}
	
	public ModelProduct(ModelProductId id) {
		this.id = id;
	}

	public ModelProductPrice getProductPrice() {
		return price;
	}

	public void setProductPrice(ModelProductPrice price) {
		this.price = price;
	}

	public ModelProductQuantity getProductQuantity() {
		return quantity;
	}

	public void setProductQuantity(ModelProductQuantity quantity) {
		this.quantity = quantity;
	}

	public ModelProductWarranty getProductWarranty() {
		return warranty;
	}

	public void setProductWarranty(ModelProductWarranty warranty) {
		this.warranty = warranty;
	}

	public ModelProductVAT getProductVAT() {
		return vat;
	}

	public void setProductVAT(ModelProductVAT vat) {
		this.vat = vat;
	}

	public ModelProductStatus getStatus() {
		return status;
	}

	public void setStatus(ModelProductStatus status) {
		this.status = status;
	}

	public ModelProductId getId() {
		return id;
	}

	public void setId(ModelProductId id) {
		this.id = id;
	}


	public ModelProductDescriber getDescriber() {
		return describer;
	}

	public void setDescriber(ModelProductDescriber describer) {
		this.describer = describer;
	}

	public ModelSupplier getSupplier() {
		return supplier;
	}

	public void setSupplier(ModelSupplier supplier) {
		this.supplier = supplier;
	}

	public ModelProductType getProductType() {
		return productType;
	}

	public void setProductType(ModelProductType productType) {
		this.productType = productType;
	}

	public ModelProductSize getProductSize() {
		return productSize;
	}

	public void setProductSize(ModelProductSize productSize) {
		this.productSize = productSize;
	}

	public ModelProductColor getProductColor() {
		return productColor;
	}

	public void setProductColor(ModelProductColor productColor) {
		this.productColor = productColor;
	}

	public ModelProductMaterial getProductMaterial() {
		return productMaterial;
	}

	public void setProductMaterial(ModelProductMaterial productMaterial) {
		this.productMaterial = productMaterial;
	}

	public ModelProductImage getProductImage() {
		return productImage;
	}

	public void setProductImage(ModelProductImage productImage) {
		this.productImage = productImage;
	}

	public ModelProductStatus getProductStatus() {
		return status;
	}

	public void setProductStatus(ModelProductStatus status) {
		this.status = status;
	}

	public ModelProductName getProductName() {
		return productName;
	}

	public void setProductName(ModelProductName productName) {
		this.productName = productName;
	}

	@Override
	public int hashCode() {
		int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
	}

	@Override
	public boolean equals(Object obj) {
		 if (obj == null) {
	            return false;
	        }
	        if (getClass() != obj.getClass()) {
	            return false;
	        }
	        final ModelProduct other = (ModelProduct) obj;
	        if (!Objects.equals(this.id, other.id)) {
	            return false;
	        }
	        return true;
	}

	
	
	
}
