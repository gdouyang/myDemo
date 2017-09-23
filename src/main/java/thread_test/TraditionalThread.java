package thread_test;

/**
 * 传统线程创建
 * @author snake
 *
 */
public class TraditionalThread {
	public static void main(String[] args) {
		Thread thread = new Mythread();
		thread.start();
	}
}

class Mythread extends Thread{

	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("1: "+Thread.currentThread().getName());
			System.out.println("2: "+this.getName());
		}
	}
	
}