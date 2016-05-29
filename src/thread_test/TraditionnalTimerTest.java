package thread_test;

import java.util.Timer;
import java.util.TimerTask;

public class TraditionnalTimerTest {
	public static void main(String[] args) {
		new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("bombing!");
			}
		}, 10000,2000);
	}
}
