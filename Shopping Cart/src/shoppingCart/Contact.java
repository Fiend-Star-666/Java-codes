package shoppingCart;

public class Contact {

	private String name;
	private String Address;
	private String emailid;;
	private Long phonenum; 
	
	//Constructors
	public Contact(String name, String address, String emailid, Long phonenum) {
		super();
		this.name = name;
		this.Address = address;
		this.emailid = emailid;
		this.phonenum = phonenum;
	}

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
		return "\nContact:\n\t Name: " + name + ",\n\t Address: " + Address + ",\n\t Email-Id: " + emailid + ",\n\t Phone Number: " + phonenum ;
	}
	
}