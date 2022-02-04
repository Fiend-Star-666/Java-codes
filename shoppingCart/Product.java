package shoppingCart;
//connected to cart
//import java.util.*;
public class Product { //done
/*
  -productid
  -name
  -price
  -details
*/
	private String productid;//it can be alpha-numeric
	private String name;
	private int price;
	private String details;
	
	public Product(String productid, String name, int price, String details) {
		super();
		this.productid = productid;
		this.name = name;
		this.price = price;
		this.details = details;
	}
	
	//setters and getters
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	@Override
	public String toString() {
		return "Product \n[Product-Id=" + productid + ",\n Name=" + name + ",\n Price=" + price+" INR" + ",\n Details=" + details + "]";
	}
}