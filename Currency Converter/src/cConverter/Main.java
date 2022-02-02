package cConverter;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		//creating scanner
		Scanner inpt = new Scanner(System.in);
		
		//Taking Input
		Print.pp("Input the Source Currency, the value to be converted and the Currency to be converted to:");
		String oldcurr=inpt.next();
		Double num=inpt.nextDouble();
		String Newcurr=inpt.next();
	
	//Passing to Converter
	Converter.Checker(oldcurr, num, Newcurr);
	
	inpt.close();
	}

}
