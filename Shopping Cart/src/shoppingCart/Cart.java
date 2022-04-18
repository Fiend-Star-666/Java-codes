package shoppingCart;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
/**
 * 
 * @author gursimran
 * Methods:
 * 	addProduct to cart via Choice(via ID or Via Name)
 *  Create Invoice via File handling
 *  Remove Product from Cart
 *  
 */

public class Cart {
	private String details;
	private Customer customr;
	private Map<String, Integer> Items = new HashMap<>();
	private List<String> invoicestr=new ArrayList<>();
	private String divider="|-------------------------------------------------------------------------|";

	//getters and setters
	public Customer getCustomr() {
		return customr;
	}

	public void setCustomr(Customer customr) {
		this.customr = customr;
	}
	
	//Method to get details of the Cart: Total Price and Total Quantity
	public String getDetails() {
		int Total_val=0;
		int Total_items=0;
		for(Map.Entry<String, Integer> x:Items.entrySet()){    
			List<Product> prodlst=new ArrayList<Product>();
			file_handling fh=new file_handling();
			prodlst=fh.reader();
			Total_items+=x.getValue();
			for(Product srch: prodlst) {
				if(srch.getProductid().equals(x.getKey())) {
					Total_val+=srch.getPrice()*x.getValue();
					continue;
					}
				}
	          }
		details="Cart Details:\n"+"\tTotal Price of the Cart is: "+Total_val+"INR\n\tTotal number of Items are: "+Total_items+"\n";
		customr.getCart().setDetails(details);
		return details;
	}

	public void setDetails(String details){
		this.details.concat(details);
	}
	
	//Method to provide the Choice to Add Product to Cart via Product ID or Product Name
	public void addproductchoice(){
		Scanner scan=new Scanner(System.in);
		System.out.println("How many Products do you wanna add into your Cart:\n");
		
		int num = scan.nextInt();		
		
		for(int i=0;i<num;i++){
			System.out.println("Do you want to add the product via:\n1. Name\n2. Product-ID\n enter choice below:");
			int choice = Integer.parseInt(scan.next()+scan.nextLine());;
			switch(choice){
			case 1:
				System.out.println("Enter the Product-Name and the Quantity");
				customr.getCart().addProductvianame(scan.next()+scan.nextLine(), scan.nextInt());
				break;
			case 2:
				System.out.println("Enter the Product-ID and the Quantity");
				customr.getCart().addProductviaid(scan.next(), scan.nextInt());
				break;
			default:
				System.out.println("invalid Choice");
				addproductchoice();
				break;
				}
			}
			//scan.close();
		}
	
	//Add product to cart via product-id
	public void addProductviaid(String ID, int quantity){
		int flag=0;
			List<Product> prodlst=new ArrayList<Product>();
			file_handling fh=new file_handling();
			prodlst=fh.reader();
			for(Product srch: prodlst) {
				if(srch.getProductid().equalsIgnoreCase(ID)){
					if(Items.containsKey(ID.toUpperCase())) {
						for(Map.Entry<String, Integer> prdcrt:Items.entrySet()){    
					           if(prdcrt.getKey().equalsIgnoreCase(ID)) {
					        	   quantity+=prdcrt.getValue();
					        	   removeProduct(ID);
					           	}
							}
						}
					Items.put(srch.getProductid(), quantity);
					System.out.println("Product with Product-ID:"+ srch.getProductid()+" was succesfully added to cart with its quantity set to: "+quantity);
					itemprint(srch, quantity); //for invoice
					flag=1;
					break;
					}
			}
			if(flag==0) {
				System.out.println("Product-ID entered was Incorrect, Please enter again");
				addproductchoice();
			}
	}

	//Add product to cart via Name
	public void addProductvianame(String NAME, int quantity){    
		int flag=0;
		List<Product> prodlst=new ArrayList<Product>();
		file_handling fh=new file_handling();
		prodlst=fh.reader();
		for(Product srch: prodlst) {
			if(srch.getName().equalsIgnoreCase(NAME)) {
				if(srch.getProductid().equalsIgnoreCase(srch.getProductid())){
					if(Items.containsKey(srch.getProductid().toUpperCase())) {
						for(Map.Entry<String, Integer> prdcrt:Items.entrySet()){    
					           if(prdcrt.getKey().equalsIgnoreCase(srch.getProductid())) {
					        	   quantity+=prdcrt.getValue();
					        	   removeProduct(srch.getProductid());
					           	}
							}
						}
				}
				Items.put(srch.getProductid(), quantity);
				System.out.println("Product with Product-Name:"+ srch.getName()+" was succesfully added to cart with its quantity set to: "+quantity);
				itemprint(srch, quantity);
				flag=1;
				break;
				}
			}
		if(flag==0) {
			System.out.println("Product-Name entered was wrong, Please enter again");
			addproductchoice();
		}
	}
	
	//Method to remove the Product from the Cart and the Draft Invoice
	public void removeProduct(String Prdctid){
		for(Map.Entry<String, Integer> prdcrt:Items.entrySet()){    
	           System.out.println(prdcrt.getKey()+" "+prdcrt.getValue());
	           if(prdcrt.getKey().equalsIgnoreCase(Prdctid)) {
	        	   Items.remove(prdcrt.getKey(),prdcrt.getValue());
	           for(int i=0;i<invoicestr.size();i++){
	        	   if(invoicestr.get(i).contains(Prdctid.toUpperCase()))
	        	      invoicestr.remove(i);
	            }
	   		   System.out.println("Product with Product-Id: "+ Prdctid +" was deleted successfully");
	           break;
	           }
	     }
	}
	
	//Method to add items to draft Invoice
	private void itemprint(Product prod, int quantity){
		String Nme=String.format(" %s %s %9s",  prod.getName(), prod.getProductid(),"");
		Nme = Nme.substring(0, Math.min(Nme.length(), 23));
		String str=String.format("|%s||%10dINR\t||%6d\t\t||\t%2dINR \t\t\n"+divider+"\n",Nme, prod.getPrice(),quantity, (prod.getPrice()*quantity));
		invoicestr.add(str);
	}
	
	private String itemprint() {
		String str="";
		for(String x: invoicestr) {
			str+=x;
		}
		return str;
	}
	
	//Creation of unique Invoice by File Handling 
	public void CreateInvoice(Customer customr){
		int min=1;
		int max=Integer.MAX_VALUE;
		String INVid=(customr.getCustid()+"INV"+(int)(Math.random()*(max-min+1)+min));
		Set<String> setINVID = new HashSet<>();
		while(setINVID.contains(INVid)){
			INVid=(customr.getCustid()+"INV"+(int)(Math.random()*(max-min+1)+min));
		}
		setINVID.add(INVid);
		LocalDateTime dt=LocalDateTime.now();
		DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("HH:mm	dd-MM-yyyy");  
			File prodlist = new File(INVid+".txt");
			try {
				prodlist.createNewFile();
				System.out.println("Invoice with Invoice ID:"+INVid+ " Created Successfully");
				FileWriter writer=new FileWriter(INVid+".txt");
				String welcome="-----------------------Thanks for using our Shopping Centre-----------------------\n";
				String strtstr="Invoice-ID: "+INVid+" of Customer: "+customr.getContact().getName()+" and with ID: "+customr.getCustid()+" is as follows:"+"\n\n";
				String endstr="\nCustomer Details: "+customr.viewCustomercntct(customr)+"\n Date and Time:\t"+dt.format(dtformat);
				String midstr="| Product\t\t\t\t||\tPrice\t\t||\tQuantity\t||\tTOTAL";
				writer.write(welcome+strtstr+divider+"\n"+String.format("%s %9s\n%s",midstr,"|",divider)+"\n"+itemprint()+"\n"+customr.getCart().getDetails()+endstr);
				writer.close();
			}	catch(IOException e){
				e.printStackTrace();
			}
		}
	
	@Override
	public String toString() {
		return "Cart [ \n\tDetails:\n" + customr.getCart().getDetails() + ", Customer:\n" + customr.toString() + ", Items:" + Items + "]";
	}
}