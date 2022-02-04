package shoppingCart;

//connected to customer
public class Contact { //done
/*//maybe create a checker for valid email and phone number
  -name
  -Address
  -emailid	
  -phonenum
  _______________________
  +updateContact(Contact) // we won't have this here because the update contact has to be in customer
*/	
	private String name;
	private String Address;
	private String emailid;;
	private Long phonenum; //int won't satisfy the limits of a phone number as its a 10 digit numeral
	
	//Constructors
	public Contact(String name, String address, String emailid, Long phonenum) {
		super();
		this.name = name;
		this.Address = address;
		this.emailid = emailid;
		this.phonenum = phonenum;
	}
	
	/* not neeeded
	public Contact(){
		this.name = null;
		this.Address = null;
		this.emailid = null;
		this.phonenum = null;
	}*/


	//getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public Long getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(Long phonenum) {
		this.phonenum = phonenum;
	}
	
	@Override
	public String toString() {
		return "\nContact:\n Name=" + name + ",\n Address=" + Address + ",\n Email-Id=" + emailid + ",\n Phone Number=" + phonenum ;
		
	}
	
	/*not needed
	 public void updateContact(Contact contact){
		//for dynamically create a menu driven switch case with an option to repeat the switch such that you can do multiple updates via console.
		this.name = contact.getName();
		Address = contact.getAddress();
		this.emailid = contact.getEmailid();
		this.phonenum = contact.getPhonenum();
	}
	*/
	
}