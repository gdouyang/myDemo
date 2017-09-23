package redis.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class Example
{
    @Autowired
    PersonRepository repository;
    
    @Autowired
    public RedisTemplate<String, String> template;
    
    public void addLink()
    {
        Person rand = new Person("rand1", "al'thor");
        rand.setAddress(new Address(new Point(13.361389D, 38.115556D)));
        
        repository.delete("rand1");
        
        repository.save(rand);
        
        //repository.findAll();
        
        List<Person> persons =
            repository.findByAddressLocationNear(new Point(15D, 37D),
                new Distance(200, Metrics.KILOMETERS));
        System.out.println("persons = "+persons);
        
        List<Person> persons1 =
            repository.findByAddressLocationWithin(new Circle(
                new Point(15D, 37D), new Distance(200, Metrics.KILOMETERS)));
        //Distance.
        System.out.println("persons1 = "+persons1);
    }
    
}
