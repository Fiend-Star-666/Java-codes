package shoppingCart;

import java.util.*;

public class Main {
	public static List<Product> prodList = new ArrayList<Product>();
	static {
		prodList.add(new Product("7ac", "electronic", 845, "its an electronic"));
	}//static initializer block
	
	public static void main(String[] args) {
		//for testing purposes right now
		Contact c1=new Contact("heelo", "169yad", "hello@hehe.com", 8295611087L);
		//c1.updateContact(c1);
		//c1.setName(name); a possibility
		Customer customer = new Customer("1a", c1, new Cart()); 
		//Customer customer = new Customer("1a", new Customer(custid, contact, cart), new Cart()); //a possibility
		customer.updateContact(c1);
		
	}
}