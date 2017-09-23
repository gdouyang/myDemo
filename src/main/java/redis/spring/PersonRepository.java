package redis.spring;

import java.util.List;

import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, String>
{
	
	List<Person> findByAddressLocationNear(Point point, Distance distance);
	
	List<Person> findByAddressLocationWithin(Circle circle);
}
