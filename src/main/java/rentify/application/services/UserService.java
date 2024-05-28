package rentify.application.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import rentify.application.entities.User;
@Service
public interface UserService {
	
	void addUser(User user) throws Exception;
   Optional<User> getUserByName(String userName);
   User getUserById(int id);
}
