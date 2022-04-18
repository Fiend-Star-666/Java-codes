package shoppingCart;
import java.util.HashSet;
import java.util.Set;
import java.util.*;


import shoppingCart.Cart;
import shoppingCart.Contact;
import shoppingCart.Customer;
//This is the class containing all the Scenarios

public class Scenarios {		
	/* Sandbox Testing Scenario:
	 *  An almost empty Customer object is created and given a unique but random Customer ID
	 * 	Contact is already provided
	 * 		1) Cart will be created via user input
	 * 		2) Invoice will be created
	 */
	public static void sandbox(){
		//maybe try to create a stock like thing and view rdg
		//create Customer and add this product into the cart
		int min=1;
		int max=Integer.MAX_VALUE;
		String custid=("CID"+(int)(Math.random()*(max-min+1)+min));
		Set<String> setCID = new HashSet<>();
		while(setCID.contains(custid)){          
			custid=("CID"+(int)(Math.random()*(max-min+1)+min));
		}
		setCID.add(custid);
		Contact cntct = new Contact("Gursimran Singh", "169, Yadhav Colony, Pinjore, Distt:Panchkula", "gsingh3_be18@Thapar.edu", 8295611087L);
		Customer cstmr = new Customer(custid, cntct, new Cart());
		cstmr.setContact(cntct);
		
		cstmr.getCart().setCustomr(cstmr);
		//System.out.println("Add Products to Cart:");
		cstmr.getCart().addproductchoice();
		cstmr.getCart().CreateInvoice(cstmr);
	}
		
		/*
		 * Scenario 1:
		 *  An almost empty Customer object is created and given a unique but random Customer ID
		 * 		1) Contact will be added via user input
		 * 		2) Cart will be created via user input
		 * 		3) Invoice will be created
		 */
		public static void scenario1(){
			int min=1;
			int max=Integer.MAX_VALUE;
			String custid=("CID"+(int)(Math.random()*(max-min+1)+min));
			Set<String> setCID = new HashSet<>();
			while(setCID.contains(custid)){          
				custid=("CID"+(int)(Math.random()*(max-min+1)+min));
			}
			setCID.add(custid);
			Contact cntct = null;
			Customer cstmr = new Customer(custid, cntct, new Cart());
			cstmr.updateContact(cntct);
			cstmr.getCart().setCustomr(cstmr);
			cstmr.getCart().addproductchoice();
			
			String sr=cstmr.viewCart(cstmr.getCart());
			System.out.println(sr);
			
			cstmr.getCart().CreateInvoice(cstmr);
		}
		
		
		public static void customscenario(){
			//creating everything from scratch
			//TO BE COMPLETED GIVE CHOICE TO everything
			file_handling filehandler=new file_handling();
			filehandler.reader();
			System.out.println("-----------------------Welcome to our Shopping Centre-----------------------");
			int min=1;
			int max=Integer.MAX_VALUE;
			String custid=("CID"+(int)(Math.random()*(max-min+1)+min));
			Set<String> setCID = new HashSet<>();
			while(setCID.contains(custid)){          
				custid=("CID"+(int)(Math.random()*(max-min+1)+min));
			}
			setCID.add(custid);
			System.out.println("Customer ID: "+custid);
			Contact cntct = null;
			Customer cstmr = new Customer(custid, cntct, new Cart());
			
			Scanner sc = new Scanner(System.in);
			boolean flag=true;
			
			while(flag) {
				System.out.println("\nChoose your Choices:"
						+ "\n\t1). Add Contact"
						+ "\n\t2). Update Contact"
						+ "\n\t3). Add Product to cart"
						+ "\n\t4). Remove product from Cart"
						+ "\n\t5). View Cart"
						+ "\n\t6). View Contact"
						+ "\n\t7). Create Invoice"
						+ "\n\t8). View Inventory"
						+ "\n\t0). EXIT\n");
				System.out.print("Choice:");
				int choices=sc.nextInt();
				
				switch(choices) {
				case 1:
				case 2:
					cstmr.updateContact(cntct);
					cstmr.getCart().setCustomr(cstmr);
					cntct=cstmr.getContact();
					break;
				case 3:
					cstmr.getCart().setCustomr(cstmr);
					cstmr.getCart().addproductchoice();
					break;
				case 4:
					cstmr.getCart().setCustomr(cstmr);
					
					System.out.println("What's the product id of the product that you want to remove");
					String str=sc.next();
					cstmr.getCart().removeProduct(str);
					break;
				case 5:
					cstmr.getCart().setCustomr(cstmr);
					
					System.out.println("Cart is shown in a condensed Form of just product id and Quantity");
					String sr=cstmr.viewCart(cstmr.getCart());
					System.out.println("\t"+sr);
					break;
				case 6:
					cstmr.getCart().setCustomr(cstmr);
					
					cstmr.getCart().setCustomr(cstmr);
					cstmr.getContact().toString();
					break;
				case 7:
					cstmr.getCart().setCustomr(cstmr);
					
					cstmr.getCart().CreateInvoice(cstmr);
					break;
				case 8:
					filehandler.viewer();
					break;
				case 0:
					cstmr.getCart().setCustomr(cstmr);
					
					flag=false;
					System.out.println("Program Has ended");
					break;
				default:
					cstmr.getCart().setCustomr(cstmr);
					System.out.println("Wrong input");
					break;
				}
			}
		}
}
