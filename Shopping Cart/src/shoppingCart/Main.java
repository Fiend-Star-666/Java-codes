package shoppingCart;

import java.util.Scanner;

/**
 * 
 * @version 0.0.1-snapshot
 * @author gursimran
 * Methods:
 * 		Different Scenarios can be run here
 * 		1) implementation with pre-added contact
 * 		2) implementation with everything from scratch
 * 		3) menu driven working
 */	
public class Main {
	public static void main(String[] args) {
		//code to add inventory to the list		
		file_handling filehandler=new file_handling();
		filehandler.reader(); //to read inventory
		//filehandler.viewer(); //uncomment this if you wanna see the product list
		
	
		//Scenarios Given below
		//Sttc.sandbox();	  //implementation with pre-added contact
		//Sttc.scenario1();   //everything from scratch
		Sttc.customscenario();//menu driven working
		
		//to close all the Scanners which were'nt closed before
		Scanner exit=new Scanner(System.in);
		exit.close();
	}
}
