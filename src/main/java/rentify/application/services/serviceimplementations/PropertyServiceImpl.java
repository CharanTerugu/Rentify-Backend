package rentify.application.services.serviceimplementations;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;

import rentify.application.dto.PropertyDto;
import rentify.application.dto.UserDto;
import rentify.application.entities.Property;
import rentify.application.entities.User;
import rentify.application.repositories.PropertyRepository;
import rentify.application.services.PropertyService;
import rentify.application.services.UserService;

@Service
public class PropertyServiceImpl implements PropertyService {

	@Autowired
	PropertyRepository repo;
	@Autowired
	UserService us;
	@Override
	public void addProperty(Property property , String userName) {
		// TODO Auto-generated method stub
		Optional<User> user=us.getUserByName(userName);
		
		property.setUser(user.get());
		repo.save(property);
	}
	@Override
	public List<PropertyDto> getAllProperities() {
		// TODO Auto-generated method stub
		List<PropertyDto> result=repo.findAll()
				.stream().
				map(obj->new PropertyDto(obj.getId(),obj.getPlace(),obj.getArea(),obj.getNoOfBedrooms(),obj.getLikes())).
				collect(Collectors.toList());
		return result;
	}
	@Override
	public void deletePropertyById(int propertyId) {
		// TODO Auto-generated method stub
		Property property=repo.getById(propertyId);
		property.setUser(new User());
		repo.save(property);
		repo.deleteById(propertyId);
		
	}
	@Override
	public void updateProperty(int propertyId ,Property property) {
		// TODO Auto-generated method stub
		Property data=repo.getById(propertyId);
		if(property.getNoOfBedrooms()!=0)
			data.setNoOfBedrooms(property.getNoOfBedrooms());
		if(!property.getArea().isEmpty())
		data.setArea(property.getArea());
		if(!property.getPlace().isEmpty())
		data.setPlace(property.getPlace());
		repo.save(data);
	}
	@Override
	public List<PropertyDto> getProperties(String userName) {
		// TODO Auto-generated method stub
	Optional<User>	user=us.getUserByName(userName);
	int id=user.get().getUserId();
		List<PropertyDto> result= repo.getPropertiesByUserId(id).
				stream().
				map(obj->new PropertyDto(obj.getId(),obj.getPlace(),obj.getArea(),obj.getNoOfBedrooms(),obj.getLikes())).
				collect(Collectors.toList());
		return result;
	}
	@Override
	public void updateLikes(int id) {
		// TODO Auto-generated method stub
	Property property=repo.getById(id);
	property.setLikes(property.getLikes()+1);
	repo.save(property);
	}
	@Override
	public UserDto getSellerDetails(int id) {
		// TODO Auto-generated method stub
		Property property=repo.getById(id);
		int userId=property.getUser().getUserId();
		User user=us.getUserById(userId);
		
		return new UserDto(user.getUserId(),user.getFirstName(),user.getLastName(),user.getEmail(),user.getPhoneNumber()) ;
	}
	@Override
	public List<PropertyDto> filterProperties(int bedrooms) {
		// TODO Auto-generated method stub
		List<PropertyDto> properties=repo.findAll().
				stream().
				map(obj->new PropertyDto(obj.getId(),obj.getPlace(),obj.getArea(),obj.getNoOfBedrooms(),obj.getLikes())).
				collect(Collectors.toList());
		if(bedrooms!=0) {
			
		 List<PropertyDto> result = properties.stream()
			        .filter(a -> a.getNoOfBedrooms() >=bedrooms)
			        .collect(Collectors.toList());
result.stream().forEach(a->System.out.println(a.getId()));
		return result;
		}
		return properties;
		
	}
	@Override
	public PropertyDto getPropertyById(int id) {
		// TODO Auto-generated method stub
		Property property=repo.getById(id);
		return new PropertyDto(property.getId(), property.getPlace(), property.getArea(), property.getNoOfBedrooms(), property.getLikes());
	}

}
