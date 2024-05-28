package rentify.application.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity(name="property")
public class Property {
	
	@Id
	@GeneratedValue
	int id;
    String place;
    String area;
    int noOfBedrooms;
    long likes;
    @ManyToOne(cascade = CascadeType.ALL)
    User user;
    
	public Property() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Property(int id, String place, String area, int noOfBedrooms, long likes, User user) {
		super();
		this.id = id;
		this.place = place;
		this.area = area;
		this.noOfBedrooms = noOfBedrooms;
		this.likes = likes;
		this.user = user;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getNoOfBedrooms() {
		return noOfBedrooms;
	}
	public void setNoOfBedrooms(int noOfBedrooms) {
		this.noOfBedrooms = noOfBedrooms;
	}
	public long getLikes() {
		return likes;
	}
	public void setLikes(long likes) {
		this.likes = likes;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
    
}
