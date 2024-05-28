package rentify.application.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import rentify.application.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	@Query("select u from user u where u.firstName=?1")
	public Optional<User> findyByName(String userName);
}
