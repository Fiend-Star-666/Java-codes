package shoppingCart;
import java.util.*;

//connected to contact and cart
public class Customer {//done
/*
  -custid 
  -Contact
  -Cart
  __________________________//why does the customer and the contact has the updateContact(contact) method
  +updateContact(Contact)
  +viewCart()
*/
	private String custid;//it can be alpha-numeric
	private Contact ctt;
	private Cart crt;
	
	public Contact getContact() {
		return ctt;
	}

	public void setContact(Contact contact1) {
		this.ctt = contact1;
	}

	public Cart getCart() {
		return crt;
	}

	public void setCart(Cart cart1) {
		//cart1.addProduct();//this is possible
		this.crt = cart1;
	}

	public String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}
	/*test
	//private Contact ctt= new Contact();
	//private Cart crt= new Cart();
	  -name
	  -Address
	  -emailid
	  -phonenum
	*/

	public Customer(String custid1, Contact contact1, Cart cart1) {
		super();
		this.custid = custid1;
		this.ctt = contact1;
		this.crt = cart1;
	}	
	
	//*///Dynamic implementation here i guess
	public void updateContact(Contact contact1){
		Scanner stringScan=new Scanner(System.in);
		Scanner intScan =new Scanner(System.in);
		System.out.println("Your Current Contact is:"+contact1.toString()+"\n");
		 System.out.println("What do you want to Update:\n 1. Name\n 2. Address\n 3. Email Id\n 4. Phone Number");
		 int choice=intScan.nextInt();
		 
		 String answer = null;
		 //input.close();
			switch(choice){
			
			case 1: //update name
				System.out.println("Please enter new Name:");
				contact1.setName(stringScan.nextLine());
				System.out.println("Do you want to update anything else:");
				answer=(stringScan.next());
				break;
				
			case 2: //update Address
				System.out.println("Please enter new Address:");
				contact1.setAddress(stringScan.nextLine());
				System.out.println("Do you want to update anything else:");
				answer=(stringScan.next());
				break;
			
			case 3: //update Emailid
				System.out.println("Please enter new Email-Id:");
				contact1.setEmailid(stringScan.next());
				System.out.println("Do you want to update anything else:");
				answer=(stringScan.next());
				break;
				
			case 4: //update phone num
				System.out.println("Please enter new Phone Number:");
				contact1.setPhonenum(intScan.nextLong());
				System.out.println("Do you want to update anything else:");
				answer=(stringScan.next());
				break;
			
			default: 
				System.out.println("Invalid Choice");
				System.out.println("Do you Still want to update anything:");
				answer=(stringScan.next());
				break;
		}

		if(answer.toLowerCase().equals("yes")) {
			System.out.println("____________________________________________________");
			System.out.println("Enter your Choice:");
			updateContact(contact1);
			/* switch(temp) won't work butwe can do this
			updateContact(contact);//How to reuse switch?
			*/
		}
		else if(answer.toLowerCase().equals("no")){
			System.out.println("____________________________________________________");
			System.out.println("Updates has been successfully performed\n Your new Contact is:"+contact1.toString());
		}
		else {
			System.out.println("invalid Choice\nPlease Enter Again");
			System.out.println("____________________________________________________");
			updateContact(contact1);
		}
		intScan.close();
		stringScan.close();
	}
	
	//for viewing everything of Customer
	@Override
	public String toString() {
		return "Customer: \n[Customer ID=" + custid + ",\n contact=" + ctt.toString() + "\n, Cart=" + crt.toString() + "]";
	}
	public void viewCustomer(Customer cust){
		cust.toString();//maybe or something similar to view the Map
	}
	
	
	//implementation to be decided
	public void viewCart(Cart crt){
		crt.toString();//maybe or something similar to view the Map
	}
}