package rentify.application.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name="user")
public class User {
@Id
@GeneratedValue
int userId;
String firstName;
String lastName;
String email;
String phoneNumber;
String roles;
String password;

public User() {
	super();
	// TODO Auto-generated constructor stub
}



public User(int userId, String firstName, String lastName, String email, String phoneNumber, String roles,
		String password) {
	super();
	this.userId = userId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.phoneNumber = phoneNumber;
	this.roles = roles;
	this.password = password;
}



public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public String getRoles() {
	return roles;
}
public void setRoles(String roles) {
	this.roles = roles;
}



public String getPassword() {
	return password;
}



public void setPassword(String password) {
	this.password = password;
}

}
