package ata;
import java.util.ArrayList;

public class Cart {
	private ArrayList<Product> items = new ArrayList<>();
	private double total;
	private double taxRate = 10.0;
	
	public void addItem(Product p) {
		total = 0;
		items.add(p);
		System.out.println(String.format("%s added to cart.", p.getName()));
		for(Product item : items) {
			total += item.getPrice();	
		}
		System.out.println(total);
		
	}
	
	public double postTotal() {
		return total * (1 + taxRate/100);
		//return total + ((total*taxRate)/100);
	}
	
	public void showDetails() {
		StringBuilder detailSB = new StringBuilder();
		if(items.isEmpty()) {
			detailSB.append(String.format("The cart is empty. " +
					"Please add at least one product to see it in the cart.%n"));
			
		} else {
			appendCartHeaderToStringBuilder(detailSB);
			appenditemsWithPricesTostringBuilder(detailSB);
			appendCartTotalToStringBuilder(detailSB);
		}
		System.out.println(detailSB);
	}
	
	private void appendCartHeaderToStringBuilder(StringBuilder sb) {
		sb.append(String.format("--Cart--%n"));
		sb.append(String.format("Item Count: %d%n", items.size()));
	}
	
	private void appenditemsWithPricesTostringBuilder(StringBuilder sb) {
		sb.append(String.format("Items:%n"));
		for(Product item: items) {
				sb.append(String.format("%s: $%.2f%n", item.getName(), item.getPrice()));
		}
		sb.append(String.format("%n"));
	}
	
	private void appendCartTotalToStringBuilder(StringBuilder sb) {
		sb.append(String.format("%s: $%.2f%n", "Pre-Tax total", total));
		sb.append(String.format("%s (%.2f%% Tax): $%.2f", "Post Tax Total", taxRate, postTotal()));
	}
	
	 private void empty(){
	        items.clear();
	    }
	
	public void checkOut() {
		if(items.isEmpty()) {
			System.out.println("Your cart is currently empty. Please add at least one product to check out.");
		} else {
			System.out.println(String.format("Your total is $%.2f", postTotal()));
			System.out.println("Thank you for shopping at T-Shirt Mart.");
			empty();
		}
	}
}
