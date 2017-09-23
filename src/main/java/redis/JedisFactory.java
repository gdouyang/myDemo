package redis;

import org.springframework.util.StringUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.Protocol;

/**
 * Jedis工厂类
 * <br> 
 * @author  OuYangGuoDong
 * @version  [版本号, 2017年9月22日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class JedisFactory
{
    private JedisShardInfo shardInfo;
    
    private String hostName = "localhost";
    
    private int port = Protocol.DEFAULT_PORT;
    
    private int timeout = Protocol.DEFAULT_TIMEOUT;
    
    private String password;
    
    private JedisPoolConfig poolConfig = new JedisPoolConfig();
    
    private String clientName;
    
    private boolean useSsl = false;
    
    private JedisPool pool;
    
    public JedisFactory(String hostName, int port)
    {
        if (shardInfo == null)
        {
            shardInfo = new JedisShardInfo(hostName, port);
            
            if (StringUtils.hasLength(password))
            {
                shardInfo.setPassword(password);
            }
            
            if (timeout > 0)
            {
                shardInfo.setSoTimeout(timeout);
            }
        }
        pool =
            new JedisPool(poolConfig, shardInfo.getHost(), shardInfo.getPort(),
                shardInfo.getSoTimeout(), shardInfo.getPassword(),
                Protocol.DEFAULT_DATABASE, clientName, useSsl);
    }
    
    /**
     * 获得Jedis
     * <br> 
     * @return
     * @author  OuYangGuoDong
     * @see [类、类#方法、类#成员]
     */
    public Jedis getJedis()
    {
        return pool.getResource();
    }
    
    public JedisShardInfo getShardInfo()
    {
        return shardInfo;
    }
    
    public void setShardInfo(JedisShardInfo shardInfo)
    {
        this.shardInfo = shardInfo;
    }
    
    public String getHostName()
    {
        return hostName;
    }
    
    public void setHostName(String hostName)
    {
        this.hostName = hostName;
    }
    
    public int getPort()
    {
        return port;
    }
    
    public void setPort(int port)
    {
        this.port = port;
    }
    
    public int getTimeout()
    {
        return timeout;
    }
    
    public void setTimeout(int timeout)
    {
        this.timeout = timeout;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public JedisPoolConfig getPoolConfig()
    {
        return poolConfig;
    }
    
    public void setPoolConfig(JedisPoolConfig poolConfig)
    {
        this.poolConfig = poolConfig;
    }
    
    public String getClientName()
    {
        return clientName;
    }
    
    public void setClientName(String clientName)
    {
        this.clientName = clientName;
    }
    
    public boolean isUseSsl()
    {
        return useSsl;
    }
    
    public void setUseSsl(boolean useSsl)
    {
        this.useSsl = useSsl;
    }
    
    public JedisPool getPool()
    {
        return pool;
    }
    
    public void setPool(JedisPool pool)
    {
        this.pool = pool;
    }
    
}
