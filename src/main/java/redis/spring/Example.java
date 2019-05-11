package redis.spring;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class Example
{
    @Autowired
    PersonRepository repository;
    
    @Autowired
    public RedisTemplate<String, String> template;
    @Autowired
    public RedisTemplate<String, Person> template1;
    
    @Resource(name="redisTemplate")
    public ListOperations<String, String> listOps;
    @Resource(name="redisTemplate")
    public ListOperations<String, Person> listOps1;
    
    public void addLink()
    {
    	if(template.equals(template1)) {
    		System.out.println("same template");
    	}
        
        System.out.println(template1.opsForValue().get("pppp"));
        Person rand = new Person("rand1", "al'thor");
        template1.opsForValue().set("pppp", rand);
        System.out.println(template1.opsForValue().get("pppp"));
        template1.delete("pppp");
        template.opsForValue().set("aaabb", "aaabb");
        System.out.println(template.opsForValue().get("aaabb"));
        template.delete("aaabb");
        
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
