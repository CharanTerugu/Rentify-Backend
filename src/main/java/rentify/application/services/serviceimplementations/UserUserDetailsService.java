package rentify.application.services.serviceimplementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import rentify.application.dto.UserUserDetails;
import rentify.application.entities.User;
import rentify.application.repositories.UserRepository;




@Service
public class UserUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> user=repo.findyByName(username);
		return user.map(UserUserDetails::new).orElseThrow(()->new UsernameNotFoundException("User not found "));
	
	}
	
}
