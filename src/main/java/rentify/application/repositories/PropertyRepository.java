package rentify.application.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import rentify.application.dto.PropertyDto;
import rentify.application.entities.Property;
@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer>{

	void save(PropertyDto property);
	@Query("select p from property p where p.user.userId=?1")
     List<Property> getPropertiesByUserId(int userId);
}
