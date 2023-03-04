package ata;

import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Scanner;
//import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;

public class ShopRunner {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Product> products = new ArrayList<>(
				Arrays.asList(
						new Product(0, "Crew Neck", 14.99),
						new Product(1, "V-Neck", 17.99),
						new Product(2, "Polo", 24.99),
						new Product(3, "Boat Neck", 35.99),
						new Product(4, "Tank Top", 10.99)
				)
			);
		
		
		Cart cart = new Cart();
		Shop shop = new Shop(products, "T-Shirt Mart");
       
        Menu menu = new Menu(new Scanner(new InputStreamReader(System.in, Charset.forName("UTF-8"))), shop, cart);
        menu.greet();
        menu.executeMenu();
	}

}
