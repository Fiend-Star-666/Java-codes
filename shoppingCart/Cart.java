package shoppingCart;
import java.util.*;

//conected to Customer and product
/*
 -Map<productid,qty>
 -name		//linking name with productid if its related to the product
 -price
 -details	//does it contain the total number of items and the total price?
 ______________________________________________________________________________
 +addProduct(Product)
 +removeProduct(productId)
*/

public class Cart {
	private String name;
	private String price;
	private String details;
	private Product prdct;
	private Integer quantity;
	Map<String, Integer> Items = new HashMap<>();
	
	/*This Comment is for Future Reference
	 * private Product prdct1= new Product("7ac", "electronic", 845, "its an electronic");
	
	//implement map	
	hashmap or treemap// i.e. the question: unsorted vs sorted
	
	private Integer quantity;
	//HashMap<String, Integer> Items = new HashMap<>();
	
	Map<String, Integer> Items = new HashMap<>();
	//or
	//HashMap<String, Integer> Items = new HashMap<>();
	private Integer quantity=1;
	String temp=prdct1.getProductid();
	
	//Items.put(temp , quantity); //not working
	//Items.put(prdct1.getProductid(), quantity); //not working
	//Items.put( "hello" , 44); not working
	
	public void mymethod(){//WORKING!!! HAD TO WRAP UP THE CODE
	Items.put(prdct1.getProductid(), quantity);
	}
	
	//implementation after setter and getter of Hashmap
	*/
	

	//getters and setters 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Product getPrdct() {
		return prdct;
	}

	public void setPrdct(Product prdct) {
		this.prdct = prdct;
	}
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
/* Think for further Implementations
	public Map<String, Integer> getItems() {
		return Items;
	}

	public void setItems(Map<String, Integer> items) {
		Items = items;
	}

	public void enterInputinMap(){
		Items.put(prdct.getProductid(), quantity);
		}
	
	//methods
	public void addProduct(Product prod){//scanner
	(/.*)two thought experiments:
		1.) adding Product via input
		
		2.) Adding Product via product-id.
		
		or a combination of both
		
	(*./)
		Scanner stringScan= new Scanner(System.in);
		Scanner intScan= new Scanner(System.in);
		System.out.println("Enter Product-ID:");
		prod.setProductid(stringScan.next());
		System.out.println("Enter Name:");
		prod.setName(stringScan.next());
		System.out.println("Set the Price:");
		prod.setPrice(intScan.nextInt());
		System.out.println("Enter Product-ID:");
		prod.setDetails(stringScan.nextLine());
		System.out.println("Details has been added Successfully.");
		intScan.close();
		stringScan.close();
	}
*/
	public void removeProduct(String Prdctid){
		for(Map.Entry<String, Integer> x:Items.entrySet()){    
	           System.out.println(x.getKey()+" "+x.getValue());
	           if(x.getKey().equals(Prdctid)) {
	        	   Items.remove(x.getKey(),x.getValue());
	           }
	          }
		System.out.println("Product with Product-Id: "+ Prdctid +" was deleted successfully");
	}
	
}