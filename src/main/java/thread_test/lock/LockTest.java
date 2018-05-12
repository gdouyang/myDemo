package thread_test.lock;

import java.util.HashMap;
import java.util.Map;

/**
 * 锁的机制就是 获取、释放、等待，模拟数据库的行级锁 参考：
 * <ul>
 * <li>监视器–JAVA同步基本概念
 * http://ifeve.com/monitors-java-synchronization-mechanism/</li>
 * <li>探索 Java 同步机制
 * https://www.ibm.com/developerworks/cn/java/j-lo-synchronized/</li>
 * </ul>
 * <li>多线程开发关键技术 http://www.jasongj.com/java/multi_thread/</li>
 * </ul>
 * 
 * @author Snake
 *
 */
public class LockTest {
	static Map<Integer, Integer> dbData = new HashMap<>();

	public static void main(String[] args) {
		// 初始化5条数据
		for (int id = 0; id < 5; id++) {
			if (!dbData.containsKey(id))
				dbData.put(id, 0);
		}
		// 初始化50个用户每10个用户访问同一id的数据
		for (int i = 1; i <= 50; i++) {
			int id = i % 5;
			new Thread(() -> {
				new LockTest().add(id, 1);// 分别对数据加1
			}).start();
		}
	}

	void add(int id, int value) {
		// 根据id得到相应的行锁
		RowLock lock = RowLock.getRowLock(id);
		lock.lock();
		try {
			// 根据id得到数据
			Integer oldValue = dbData.get(id);
			// 把lock关闭，打开sleep会出现并发时数据错误
			try {
				// 模拟数据库请求处理等待时间
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String msg = "id:" + id + " ,oldValue:" + oldValue + ", addValue:" + value;
			int newValue = oldValue + value;
			dbData.put(id, newValue);
			System.out.println(msg + ", newValue:" + newValue + ", Thread:" + Thread.currentThread().getName());
		} finally {
			lock.unlock();
		}
	}

}
