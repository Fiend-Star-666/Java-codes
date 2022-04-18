package shoppingCart;

import java.io.*;
import java.util.*;
/**
 * 
 * @author gursimran
 * Methods:
 * 		Reader to read the Inventory of all the products in the inventory
 * 		Viewer to view all the items that exist in Inventory
 */
public  class file_handling {
	List<Product> productList= new ArrayList<Product>();
	
	//This Method reads the Inventory from a file/csv then adds the inventory to productlist
	public List<Product> reader(){
		File prodlist = new File("Product_List.txt");
		try {
			Scanner inptprdct = new Scanner(prodlist);
			while(inptprdct.hasNextLine()){
				String full=inptprdct.nextLine();
				String[] splt = full.split(",");
				String productId=splt[0].trim();
				String Name=splt[1].trim();
				Integer Price=Integer.parseInt(splt[2].trim());
				String Details=splt[3].trim();
				productList.add(new Product(productId, Name, Price, Details));
			}
			inptprdct.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return productList;
	}
	
	//This Method can be called to View all the Products in the inventory
	public void viewer(){
		for(Product prdct: productList) {
			System.out.println(prdct.toString()+"\n");
		}
	}
}