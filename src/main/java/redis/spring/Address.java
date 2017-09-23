package redis.spring;

import java.io.Serializable;

import org.springframework.data.geo.Point;
import org.springframework.data.redis.core.index.GeoIndexed;

public class Address implements Serializable
{
    
    private static final long serialVersionUID = -232005037310316196L;
    
    @GeoIndexed
    Point location;
    
    public Address()
    {
        
    }
    
    public Address(Point location)
    {
        super();
        this.location = location;
    }
    
    public Point getLocation()
    {
        return location;
    }
    
    public void setLocation(Point location)
    {
        this.location = location;
    }
    
}
