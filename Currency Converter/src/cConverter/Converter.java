package cConverter;

abstract class Converter implements CC{
	
	//it checks then converts while printing
	protected static void Checker(String oldcurr, Double num, String Newcurr) {

		//print USD with cents
		if(oldcurr.toUpperCase().equals("INR")) 
			Print.pp(String.format("%.2f", usD.convert(num))+" "+Newcurr.toUpperCase());
		
		//print INR UPTO rupees as paise are not in circulation
		else if(oldcurr.toUpperCase().equals("USD")) {
			Print.pp(Rupee.convert(num)+" "+Newcurr.toUpperCase());
		}
		
		//default case
		else{
			Print.pp("Invalid Currency Entered");
		}
	}
}