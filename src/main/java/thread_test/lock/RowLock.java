package thread_test.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 行锁
 * 
 * @author Snake
 *
 */
public class RowLock {
	// 设置一个容器来存放行级锁
	static final Map<Integer, RowLock> lockMap = new HashMap<>();
	static {
		for (int i = 0; i < 20; i++) {
			lockMap.put(i, new RowLock(i));
		}
	}

	public static RowLock getRowLock(int id) {
		return lockMap.get(id);
	}

	private Lock lock = new ReentrantLock();
	int lockIndex;

	public RowLock(int lockIndex) {
		this.lockIndex = lockIndex;
	}

	public void lock() {
		lock.lock();
	}

	public void unlock() {
		lock.unlock();
	}
}