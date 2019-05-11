package redis.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableRedisRepositories(basePackages = "redis.spring")
public class Configuration1
{
	@Bean
    public RedisTemplate redisTemplate(JedisConnectionFactory fac) {
    	RedisTemplate t = new RedisTemplate<>();
    	GenericJackson2JsonRedisSerializer s = new GenericJackson2JsonRedisSerializer();
    	t.setKeySerializer(new StringRedisSerializer());
    	t.setValueSerializer(s);
    	t.setConnectionFactory(fac);
    	return t;
    }
	
	//@Bean
    public RedisTemplate<String, Person> redisTemplate2(JedisConnectionFactory fac) {
    	RedisTemplate<String, Person> t = new RedisTemplate<>();
    	Jackson2JsonRedisSerializer s = new Jackson2JsonRedisSerializer<>(Person.class);
    	t.setValueSerializer(s);
    	t.setConnectionFactory(fac);
    	return t;
    }
	//@Bean
	public RedisTemplate<String, String> redisTemplate1(JedisConnectionFactory fac) {
		RedisTemplate t = new RedisTemplate<>();
		Jackson2JsonRedisSerializer s = new Jackson2JsonRedisSerializer<>(String.class);
		t.setValueSerializer(s);
		t.setConnectionFactory(fac);
		return t;
	}
 }
