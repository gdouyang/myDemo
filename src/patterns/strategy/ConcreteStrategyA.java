package patterns.strategy;

/**
 * 具体算法A
 *@author snake
 *2014-10-6-下午4:12:20
 */
public class ConcreteStrategyA extends Strategy {

	@Override
	public void algorithmInterface() {
		System.out.println("算法A实现");
	}
}
