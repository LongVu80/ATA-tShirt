package ata;

import java.util.Scanner;
import java.util.ArrayList;


public class Menu {
	
	private Scanner scanner;
	private Shop shop;
	private Cart cart;

	
    public Menu(Scanner scanner, Shop shop, Cart cart) {
        this.scanner = scanner;
        this.shop = shop;
        this.cart = cart;
    }


    public void executeMenu() {
    	printMenu();
    	MenuOption optionSelected = getNextOptionFromUser();
    	
    	while(optionSelected != MenuOption.EXIT) {
    		handleShopperMenuOptionSelection(optionSelected);
    		printMenu();
    		optionSelected = getNextOptionFromUser();
    	}
    	exit();
    }
    
    private void handleShopperMenuOptionSelection(MenuOption option) {
		if(option == MenuOption.LIST_PRODUCTS) {
			shop.printProducts();
		} else if(option == MenuOption.BUY_PRODUCT) {
			addToCart();
		} else if(option == MenuOption.FIND_PRODUCT) {
			findProduct();
		} else if(option == MenuOption.SHOW_CART) {
			cart.showDetails();
		} else if(option == MenuOption.CHECKOUT) {
			cart.checkOut();;
		} else {
            System.out.println(String.format("Option %s was selected. Not yet implemented.", option.getId()));
        }
	}
    
    private MenuOption getNextOptionFromUser() {
		return MenuOption.fromOptionId(getNextIntFromUser());
	}


    public void greet() {
        System.out.println("Hello. Please enter your name:");
        String name = scanner.nextLine();
        System.out.println(String.format("Welcome %s to %s", name, shop.getName()));
    }


    private void printMenu() {
    	StringBuilder menuSb = new StringBuilder().append(
                String.format(
                    "%n%s%n%s%n%n",
                    "--Main Menu--",
                    "Select an option using one of the numbers shown"
                )
            );

            for (MenuOption option : MenuOption.values()) {
                menuSb.append(String.format("%d: %s%n", option.getId(), option.getDisplayValue()));
            }

            System.out.print(menuSb);
    }
    
    private void findProduct() {
    	System.out.println("Enter the item to search for:");
        String itemToFind = getNextStringLineFromUser();
        int index = shop.findProduct(itemToFind);
        if (index == -1) {
            System.out.println("That product was not found.");
        } else {
            System.out.println(String.format("%s was found and its product id is %s", itemToFind, index));
        }
	}
    
    private void addToCart() {
    	System.out.println("Please enter the ID of the product you would like to purchase:");
    	int input = getNextIntFromUser();
    	Product product = shop.getProductId(input);
    	if(product != null) {
    		cart.addItem(product);
    	} else {
    		System.out.println("That item ID is invalid and could not be added to the cart.");
    	}
    }


    private void exit() {
        System.out.println("Exiting now. Goodbye.");
        scanner.close();
    }


    private int getNextIntFromUser() {
    	while (!scanner.hasNextInt()) {
			 System.out.println("Wrong type of input. Enter interger only.");
			 scanner.next();
		}
		return scanner.nextInt();
       
    }

    
    private String getNextStringLineFromUser() {
        scanner.nextLine();
        return scanner.nextLine();
    }
    

}
