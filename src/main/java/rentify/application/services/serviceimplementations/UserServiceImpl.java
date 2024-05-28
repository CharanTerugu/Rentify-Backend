package rentify.application.services.serviceimplementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import rentify.application.entities.User;
import rentify.application.repositories.UserRepository;
import rentify.application.services.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repo;

	@Autowired
	PasswordEncoder passwordEncoder;
	@Override
	public void addUser(User user) throws Exception {
		// TODO Auto-generated method stub
Optional<User> result	=repo.findyByName(user.getFirstName());
if(result.isEmpty()) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		repo.save(user);
		}
else
{
	throw new Exception("user already exsist");
}
	}
	
	@Override
	public Optional<User> getUserByName(String userName) {
		// TODO Auto-generated method stub
		return repo.findyByName(userName);
	}
	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}

}
