package test;

import java.util.LinkedList;
import java.util.List;
/**约瑟夫问题
 * */
public class YueSheFuQuestion {
	// 存放M
	List<String> list = new LinkedList<String>();
	// 一圈数数完之后，临时存放出列的人
	List<String> tmp = new LinkedList<String>();

	public YueSheFuQuestion(int m) {
		for (int i = 1; i <= m; i++) {
			list.add(i + "");
		}
	}

	/**
	 * 递归 执行主体
	 * 
	 * @param start
	 * @param n
	 */
	public void start(int start, int n) {
		int size = list.size();
		if (list.size() == 0) {
			System.out.println("结束！！");
			return;
		}
		for (int i = 1; i <= size; i++) {
			if ((i + start) % n == 0) {
				System.out.println(list.get(i - 1) + " 出局,");
				tmp.add(list.get(i - 1));
			}
		}
		// 在m中删除临时队列的人
		for (String str : tmp) {
			list.remove(str);
		}
		// 清除list
		tmp.clear();
		// 递归
		start((size + start) % n, n);
	}

	public static void main(String[] args) {
		long t1 = System.currentTimeMillis();

		// M=10
		YueSheFuQuestion yueSheFuQuestion = new YueSheFuQuestion(10);
		// n=4
		yueSheFuQuestion.start(0, 4);

		System.out.print("花费时间：");
		System.out.println(System.currentTimeMillis() - t1);
	}
}
