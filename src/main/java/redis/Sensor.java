package redis;

public class Sensor
{
    private String sensorId;
    
    private String name;
    
    private String value;
    
    /**经度*/
    private Double longitude;
    
    /**纬度*/
    private Double latitude;
    
    public String getSensorId()
    {
        return sensorId;
    }
    
    public void setSensorId(String sensorId)
    {
        this.sensorId = sensorId;
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
    
    public Double getLongitude()
    {
        return longitude;
    }
    
    public void setLongitude(Double longitude)
    {
        this.longitude = longitude;
    }
    
    public Double getLatitude()
    {
        return latitude;
    }
    
    public void setLatitude(Double latitude)
    {
        this.latitude = latitude;
    }
    
}
