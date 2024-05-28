package rentify.application.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import rentify.application.dto.PropertyDto;
import rentify.application.dto.UserDto;
import rentify.application.entities.Property;

@Service
public interface PropertyService {

	void addProperty(Property property,String userName);
	List<PropertyDto> getAllProperities();
	void deletePropertyById(int propertyId);
	void updateProperty(int propertyId,Property property);
	List<PropertyDto> getProperties(String userName);
	void updateLikes(int id);
	UserDto getSellerDetails(int id);
	List<PropertyDto> filterProperties(int bedrooms);
	PropertyDto getPropertyById(int id);
}
