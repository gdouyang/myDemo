package redis;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.alibaba.fastjson.JSONObject;

import redis.clients.jedis.GeoRadiusResponse;
import redis.clients.jedis.GeoUnit;
import redis.clients.jedis.Jedis;

public class RedisSensorUtil
{
	
	
	private static final String KEY = "markers";
	
	private static JedisFactory jedisFactory = new JedisFactory("localhost",
			6379);
	
	/**
	 * 移除所有 <br>
	 * 
	 * @author OuYangGuoDong
	 * @see [类、类#方法、类#成员]
	 */
	public static void removeAllMarker()
	{
		Jedis jedis = getJedis();
		jedis.del(KEY);
		Set<byte[]> potentialIndex = jedis
				.keys(new String(KEY + ":*").getBytes());
		
		if (!potentialIndex.isEmpty())
		{
			byte[][] keys = potentialIndex
					.toArray(new byte[potentialIndex.size()][]);
			jedis.del(keys);
			String[] members = new String[keys.length];
			for (int i = 0; i < keys.length; i++)
			{
				byte[] bs = keys[i];
				String member = new String(bs);
				members[i] = member;
			}
			jedis.zrem(KEY, members);
		}
	}
	
	public static Jedis getJedis()
	{
		return jedisFactory.getJedis();
	}
	
	/**
	 * 添加标注 <br>
	 * 
	 * @param sensor
	 * @author OuYangGuoDong
	 * @see [类、类#方法、类#成员]
	 */
	public static void addMarker(Sensor sensor)
	{
		if (null != sensor && sensor.getLatitude() != null
				&& sensor.getLongitude() != null)
		{
			Jedis jedis = getJedis();
			jedis.geoadd(KEY, sensor.getLongitude().doubleValue(),
					sensor.getLatitude().doubleValue(), sensor.getSensorId());
			
			jedis.set(KEY + ":" + sensor.getSensorId(),
					JSONObject.toJSONString(sensor));
		}
	}
	
	/**
	 * 得到指定经纬度范围的设备列表 <br>
	 * 
	 * @param longitude 经度
	 * @param latitude 纬度
	 * @param radius 半径
	 * @param unit 半径单位
	 * @author OuYangGuoDong
	 * @see [类、类#方法、类#成员]
	 */
	public static List<Sensor> getSensors(double longitude, double latitude,
			double radius, GeoUnit unit)
	{
		List<Sensor> sensors = new ArrayList<>();
		Jedis jedis = getJedis();
		List<GeoRadiusResponse> georadius = jedis.georadius(KEY, longitude,
				latitude, radius, unit);
		for (GeoRadiusResponse geoRadiusResponse : georadius)
		{
			String member = geoRadiusResponse.getMemberByString();
			String value = jedis.get(member);
			Sensor sensor = JSONObject.parseObject(value, Sensor.class);
			sensors.add(sensor);
		}
		return sensors;
	}
	
	/**
	 * 删除标注 <br>
	 * 
	 * @param sensorId
	 * @author OuYangGuoDong
	 * @see [类、类#方法、类#成员]
	 */
	public static void removeMarker(String sensorId)
	{
		Jedis jedis = getJedis();
		jedis.del(KEY + ":" + sensorId);
		jedis.zrem(KEY, sensorId);
	}
	
	public static void main(String[] args)
	{
		Sensor sensor = new Sensor();
		sensor.setSensorId("12345678");
		double latitude = 38.21234;
		sensor.setLatitude(latitude);
		double longitude = 114.343233;
		sensor.setLongitude(longitude);
		sensor.setName("test1231");
		addMarker(sensor);
		System.out.println("添加:" + sensor.getSensorId());
		List<Sensor> sensors = getSensors(longitude, latitude, 200, GeoUnit.M);
		System.out.println("sensors size = " + sensors.size());
		removeMarker(sensor.getSensorId());
		System.out.println("删除:" + sensor.getSensorId());
		sensors = getSensors(longitude, latitude, 200, GeoUnit.M);
		System.out.println("sensors size = " + sensors.size());
		removeAllMarker();
		System.out.println("删除所有");
		sensors = getSensors(longitude, latitude, 200, GeoUnit.M);
		System.out.println("sensors size = " + sensors.size());
	}
}
