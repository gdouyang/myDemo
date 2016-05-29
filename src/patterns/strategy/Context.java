package patterns.strategy;
/**
 * 上下文
 *@author snake
 *2014-10-6-下午4:14:15
 */
public class Context {
	Strategy strategy;
	
	/**
	 * 初始化时，传入具体的策略对象
	 * @param strategy
	 */
	public Context(Strategy strategy)
	{
		this.strategy = strategy;
	}
	/**
	 * 根据具体的策略对象，调用其算法的方法
	 * 
	 * 2014-10-6-下午4:15:44
	 *
	 */
	public void contextInterface()
	{
		strategy.algorithmInterface();
	}
	
}
