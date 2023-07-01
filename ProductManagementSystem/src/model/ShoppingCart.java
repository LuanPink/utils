package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
	private Map<ModelSavePrice, Integer> cart;
	 ArrayList<Integer> price = new ArrayList<Integer>();
    public ShoppingCart() {
        cart = new HashMap<>();
    }

    public void addProduct(ModelSavePrice product, int quantity) {
        cart.put(product, quantity);
    }

    public void removeProduct(ModelSavePrice product) {
        cart.remove(product);
    }

    public int getTotalPrice() {
        int totalPrice = 0;
//        System.out.println("Start: "+totalPrice);
       
        
        for (Map.Entry<ModelSavePrice, Integer> entry : cart.entrySet()) {
        	ModelSavePrice product = entry.getKey();
            int quantity = entry.getValue();
//            ModelTotalPrice.setTotalPrice(product.getPrice());
            
            if (product.isChecked()) {            
            	totalPrice = product.getPrice();
  
//            	System.out.println("Selected: "+price);
            }else {
            	totalPrice = product.getPrice();
            	
 //           	System.out.println("Unselected: "+totalPrice);
            }
        }
        return totalPrice;
    }

    public void updateChecked(ModelSavePrice product, boolean isChecked) {
        if (isChecked) {
            product.setChecked(true);
        } else {
            product.setChecked(false);
        }
    }
}
