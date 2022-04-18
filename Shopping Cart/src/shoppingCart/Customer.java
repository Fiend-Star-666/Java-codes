package shoppingCart;
import java.util.*;
/**
 * 
 * @author gursimran
 *	Methods:
 *		UpdateContact for Adding contact if empty or updating any element of contact dynamically
 */
public class Customer {
	private String custid;
	private Contact cntct;
	private Cart crt;
	
	//Getters and Setters
	public Contact getContact() {
		return cntct;
	}

	public void setContact(Contact contact1) {
		this.cntct = contact1;
	}

	public Cart getCart() {
		return crt;
	}

	public void setCart(Cart cart1) {
		this.crt = cart1;
	}

	public String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}

	//Constructor
	public Customer(String custid1, Contact contact1, Cart cart1) {
		super();
		this.custid = custid1;
		this.cntct = contact1;
		this.crt = cart1;
	}	
	
	/*
	 * Method to add or update Contact of the Customer.
	 * 		1) Add Contact only works if the Contact is empty from the starting
	 * 		2) Dynamically Update Contact via Choice for every data member of contact 
	 */
	public void updateContact(Contact contact1){
		 Scanner stringScan=new Scanner(System.in);
		 Contact c1=contact1;//dummy contact
		 if(c1==null){
			 System.out.println("Add all the Contact Details of Customer as the Contact Details are Empty");
			 System.out.println("Please enter new Name:");
			 contact1=new Contact(null, null, null, null);
			 contact1.setName(stringScan.next()+stringScan.nextLine());
			 System.out.println("Please enter new Address:");
			 contact1.setAddress(stringScan.next()+stringScan.nextLine());
			 System.out.println("Please enter new Email-Id:");
			 contact1.setEmailid(stringScan.next());
			 System.out.println("Please enter new Phone Number:");
			 contact1.setPhonenum(stringScan.nextLong());
			 System.out.println("Customer Contact has been added\n"+contact1.toString());
			 this.setContact(contact1);
			 return;
		 }
		 else
			 {System.out.println("Your Current Contact is:"+contact1.toString()+"\n");}
		 
		 System.out.println("What do you want to Update:\n 1. Name\n 2. Address\n 3. Email Id\n 4. Phone Number");
		 int choice=stringScan.nextInt();
		 String answer = null;
		 
			switch(choice){
			case 1: //update name
				System.out.println("Please enter new Name:");
				contact1.setName(stringScan.next()+stringScan.nextLine());
				System.out.println("Do you want to update anything else:");
				answer=(stringScan.next());
				break;
				
			case 2: //update Address
				System.out.println("Please enter new Address:");
				contact1.setAddress(stringScan.next()+stringScan.nextLine());
				System.out.println("Do you want to update anything else:");
				answer=(stringScan.next());
				break;
			
			case 3: //update Email-id
				System.out.println("Please enter new Email-Id:");
				contact1.setEmailid(stringScan.next());
				System.out.println("Do you want to update anything else:");
				answer=(stringScan.next());
				break;
				
			case 4: //update phone number
				System.out.println("Please enter new Phone Number:");
				contact1.setPhonenum(stringScan.nextLong());
				System.out.println("Do you want to update anything else:");
				answer=(stringScan.next());
				break;
			
			default: 
				System.out.println("Invalid Choice");
				System.out.println("Do you Still want to update anything:");
				answer=(stringScan.next());
				break;
		}
		
		if(answer.equalsIgnoreCase("yes")) {
			System.out.println("____________________________________________________");
			System.out.println("Enter your Choice:");
			updateContact(contact1);
		}
		else if(answer.equalsIgnoreCase("no")){
			System.out.println("____________________________________________________");
			System.out.println("Updates has been successfully performed\n Your new Contact is:"+contact1.toString());
		}
		else {
			System.out.println("invalid Choice\nPlease Enter Again");
			System.out.println("____________________________________________________");
			updateContact(contact1);
		}
	}
	
	//for viewing everything of Customer
	@Override
	public String toString() {
		return "\tCustomer: \n\t\t[Customer ID=" + custid + ",\n\t\tContact=" + cntct.toString()+"]";
	}
	
	//for viewing Customer Contact
	public String viewCustomercntct(Customer cust){
		return "\n" + cntct.toString();
	}
	
	//For viewing Cart
	public String viewCart(Cart crt){
		return crt.toString();
	}
}