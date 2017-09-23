package redis.spring;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import com.alibaba.fastjson.JSONObject;

@RedisHash("persons")
public class Person
{
    private Address address;
    
    @Id
    private String name;
    
    private String value;
    
    public Person(String name, String value)
    {
        super();
        this.name = name;
        this.value = value;
    }
    
    public Address getAddress()
    {
        return address;
    }
    
    public void setAddress(Address address)
    {
        this.address = address;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getValue()
    {
        return value;
    }
    
    public void setValue(String value)
    {
        this.value = value;
    }
    @Override
    public String toString()
    {
    	return JSONObject.toJSONString(this) + "@" + Integer.toHexString(hashCode());
    }
}
