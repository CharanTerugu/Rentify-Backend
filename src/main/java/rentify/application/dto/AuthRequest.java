package rentify.application.dto;

public class AuthRequest {
	String firstName;
	String password;
	public AuthRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AuthRequest(String firstName, String lastName, String passsword) {
		super();
		this.firstName = firstName;
		this.password = passsword;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
	

}
