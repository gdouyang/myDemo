package thread_test;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Fork/Join模式进行并行计算，递归任务方式会执行并得到返回值
 * <ul>
 * <li>1.每次只能完成100个任务，400个任务太大分成0-200(线程1)，200-400(线程2)</li>
 * <li>2.0-200个任务太大分解0-100(线程1),100-200(线程3)</li>
 * <li>3.200-400太大分解200-100(线程2), 300-400(线程4)</li>
 * </ul>
 * 所以任务的开始也结束都是线程1，0-100的计算也是线程1 <br>
 * 因为每次都是分解成两个任务所以，
 * 整个分解过程是每次判断自己能不能完成不能完成就把多余的任务给其它人，不是一开始自己领取0-100再把剩下的分给另外三个虽然最终效果是一样的。 <br>
 * 其实也可以直接分解把剩下的300给三个子任务但失去了灵活性只能针对总数是固定的情况。
 * 
 * fork 分叉
 * 
 * @author Snake
 *
 */
class SumTask extends RecursiveTask<Long> {

    static final int THRESHOLD = 100;
    long[] array;
    int start;
    int end;

    SumTask(long[] array, int start, int end) {
    this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
		String name = Thread.currentThread().getName();
        if (end - start <= THRESHOLD) {
            // 如果任务足够小,直接计算:
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
			System.out.println(String.format("compute %d~%d = %d, Thread = %s", start, end, sum, name));
            return sum;
        }
        // 任务太大,一分为二:
        int middle = (end + start) / 2;
		System.out.println(String.format("split %d~%d ==> %d~%d, %d~%d, Thread = %s", start, end, start, middle,
				middle, end, name));
        SumTask subtask1 = new SumTask(this.array, start, middle);
        SumTask subtask2 = new SumTask(this.array, middle, end);
		// 1.先把task2安排给其它线程(fork把任务安排给其它线程执行),当前线程继续做子任务
		// 2.使用join来执行task1(当前线程)
		// invokeAll(subtask1, subtask2);// 四个线程花费1秒
		// 都用fork相当于都给别人做自己不做 七个线程花费1秒
		subtask1.fork();
		subtask2.fork();
        Long subresult1 = subtask1.join();
        Long subresult2 = subtask2.join();
        Long result = subresult1 + subresult2;
		System.out.println("result = " + subresult1 + " + " + subresult2 + " ==> " + result + ", Thread =" + name);
        return result;
    }

	public static void main(String[] args) throws Exception {
		// 创建随机数组成的数组:
		long[] array = new long[400];
		fillRandom(array);
		// fork/join task:
		ForkJoinPool fjp = new ForkJoinPool(4); // 最大并发数4
		ForkJoinTask<Long> task = new SumTask(array, 0, array.length);
		long startTime = System.currentTimeMillis();
		Long result = fjp.invoke(task);
		long endTime = System.currentTimeMillis();
		System.out.println("Fork/join sum: " + result + " in " + (endTime - startTime) + " ms.");
	}

	private static void fillRandom(long[] array2) {
		List<Integer> collect = Stream.generate(() -> (int) (System.nanoTime() % 100)).limit(array2.length)
				.collect(Collectors.toList());
		for (int i = 0; i < collect.size(); i++) {
			array2[i] = collect.get(i);
		}
	}
}