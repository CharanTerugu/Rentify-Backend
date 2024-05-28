package rentify.application.dto;

public class PropertyDto {

	
	int id;
    String place;
    String area;
    int noOfBedrooms;
    long likes;
    
    
    
	public PropertyDto() {
		super();
		// TODO Auto-generated constructor stub
	}



	public PropertyDto(int id, String place, String area, int noOfBedrooms, long likes) {
		super();
		this.id = id;
		this.place = place;
		this.area = area;
		this.noOfBedrooms = noOfBedrooms;
		this.likes = likes;
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
    
    
}
