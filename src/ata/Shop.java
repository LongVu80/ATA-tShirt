package ata;
import java.util.ArrayList;

public class Shop {

	private ArrayList<Product> products;
//	private Cart cart;
	private String name;
	
	public Shop(ArrayList<Product> products, String name) {
		this.products = products;
//		this.cart = cart;
		this.name = name;
	}  
	
	public String getName() {
		return name;
	}
	
	
	public void printProducts() {
		System.out.println("--Products--");
		for (int i = 0; i < products.size(); i++) {
			System.out.println(String.format("ID %d: %s - $%.2f",products.get(i).getId(), products.get(i).getName(), products.get(i).getPrice()));
		}
	}
    
    public int findProduct(String searchText) {
    	for (int i = 0; i < products.size(); i++) {
    		if(searchText.equalsIgnoreCase(products.get(i).getName())) {
    			return i;
    		}
    	}
    	return -1;
    }
    
    public Product getProductId(int id) {
    	for(Product product : products) {
    		if(product.getId() == id) {
    			return product;
    		}
    	}
		return null;
	}
}
