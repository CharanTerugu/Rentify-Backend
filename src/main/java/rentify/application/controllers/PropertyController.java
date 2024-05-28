package rentify.application.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import jakarta.servlet.http.HttpServletRequest;
import rentify.application.dto.PropertyDto;
import rentify.application.entities.Property;
import rentify.application.services.PropertyService;

//@CrossOrigin(origins = "https://rentify-frontend-pink.vercel.app")
@RestController
public class PropertyController {

	
	@Autowired
	PropertyService ps;
	@PostMapping("/seller/register")
	@PreAuthorize("hasAuthority('ROLE_SELLER')")
	ResponseEntity<?> registerProperty(@RequestBody Property property,HttpServletRequest req){
		String userName=req.getUserPrincipal().getName();
		
		try {
			ps.addProperty(property,userName);
			return new ResponseEntity<>("Property registered successfully",HttpStatus.ACCEPTED);
		}
		catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		
	}
    @GetMapping("/properties/all")
    ResponseEntity<?> getAllProperties(  @RequestParam(required = false) Integer minBedrooms){
    	
    	try {
    		if(minBedrooms!=0) {
    			return new ResponseEntity<>(ps.filterProperties(minBedrooms),HttpStatus.ACCEPTED);
    		}
    		else
		return new ResponseEntity<>(ps.getAllProperities(),HttpStatus.ACCEPTED);
    	}
    	catch (Exception e) {
			// TODO: handle exception
    		return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
    	
    }
    
    @GetMapping("/seller/myproperties")
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
   ResponseEntity<?> viewMyproperities(HttpServletRequest req)
   {
    	
    	try {
    		String userName=req.getUserPrincipal().getName();
    		return new ResponseEntity<>(  ps.getProperties(userName),HttpStatus.ACCEPTED);
    	}catch (Exception e) {
			// TODO: handle exception
    		return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
   }
    
    
    
    @DeleteMapping("/seller/delete/{id}")
	@PreAuthorize("hasAuthority('ROLE_SELLER')")
    ResponseEntity<?> deleteProperty(@PathVariable int id){
    	try {
    		ps.deletePropertyById(id);
    		return new ResponseEntity<>("property deleted successfully",HttpStatus.ACCEPTED);
    				
    		
    	}catch (Exception e) {
			// TODO: handle exception
    		return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
    }
    
    @PutMapping("/buyer/likes/{id}")
    ResponseEntity<?> updateLikes(@PathVariable int id){
    	try {
    		ps.updateLikes(id);
    		return new ResponseEntity<>(HttpStatus.ACCEPTED);
    	}catch (Exception e) {
			// TODO: handle exception
    		return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
    	
    }
    
    @GetMapping("/buyer/intrested/{id}")

	@PreAuthorize("hasAuthority('ROLE_BUYER')")
    ResponseEntity<?> getSellerDetials(@PathVariable int id)
    {
    	try {
    	return new ResponseEntity<>(ps.getSellerDetails(id),HttpStatus.ACCEPTED);
    	}
    	catch (Exception e) {
			// TODO: handle exception
    		return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
    	
    }
    @GetMapping("/seller/property/{id}")
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    ResponseEntity<?> getProperty(@PathVariable int id)
    {
    	try {
    	return new ResponseEntity<>(ps.getPropertyById(id),HttpStatus.ACCEPTED);
    	}
    	catch (Exception e) {
			// TODO: handle exception
    		return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
    }
    
    @PutMapping("/seller/property/update/{id}")
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    ResponseEntity<?> updateProperty(@PathVariable int id, @RequestBody Property property)
    {
    	try {
    		ps.updateProperty(id, property);
    		return new ResponseEntity<>("updated successfully",HttpStatus.ACCEPTED);
    	}catch (Exception e) {
			// TODO: handle exception
    		return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
    }
    
}
