package patterns.strategy;
/***
 * <strong>策略模式：</strong>它定义了算法家族，分别封装起来，让它们之间可以
 * 互相替换，此模式让算法的变化，不会影响到使用算法的客户<br><br>
 */
public class Client {
	/**
	 * 由于实例化不同的策略，所以最终在调用context.contextInterface();时
	 * 所获得的结果就不尽相同
	 * @param args
	 * 2014-10-6-下午4:18:13
	 *
	 */
	public static void main(String[] args) {
		Context context;
		context = new Context(new ConcreteStrategyA());
		context.contextInterface();
		
		context = new Context(new ConcreteStrategyB());
		context.contextInterface();
		
		context = new Context(new ConcreteStrategyC());
		context.contextInterface();
	}
}
