package rentify.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import rentify.application.dto.AuthRequest;
import rentify.application.entities.User;
import rentify.application.services.UserService;
import rentify.application.services.serviceimplementations.JwtService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

	@Autowired
	UserService us;
	@Autowired
	JwtService jwtService;
	
	@Autowired
	AuthenticationManager authmanager;
	
	@PostMapping("user/register")
	ResponseEntity<?> signUp(@RequestBody User user) {
		try {
		us.addUser(user);
		return new ResponseEntity<>("user registered successfully",HttpStatus.ACCEPTED);
		}
		catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping("user/authenticate")
	  ResponseEntity<?> authenticateAndGetToken(@RequestBody AuthRequest auth)  {
			
			Authentication authentication ;
			
			try
			{
	      authentication = authmanager.authenticate(new UsernamePasswordAuthenticationToken(auth.getFirstName(), auth.getPassword()));
	     String token= jwtService.generateToken(auth.getFirstName(),authentication.getAuthorities());
	    
	     return new ResponseEntity(token,HttpStatus.OK);
			}
			catch (Exception e) {
				return new ResponseEntity("Invalid credentials ",HttpStatus.UNAUTHORIZED);
			}
	       
	  }
	
}
