package redis.spring;

import java.net.MalformedURLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App
{
    @SuppressWarnings("resource")
    public static void main(String[] args)
        throws MalformedURLException
    {
        ApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("redis/spring/applicationContext.xml");
        
        Example bean = applicationContext.getBean(Example.class);
        
        bean.addLink();
    }
}
