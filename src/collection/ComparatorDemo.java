package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Comparator 比较器的用法
 * 
 * @author Snake
 * 
 */
public class ComparatorDemo implements Comparator<Step> {

	@Override
	public int compare(Step o1, Step o2) {
		long acceptTime1 = o1.getAcceptTime();
		long acceptTime2 = o2.getAcceptTime();

		// 对时间字段进行升序
		if (acceptTime1 > acceptTime2)
			return 1;
		return -1;
	}

	public static void main(String[] args) {
		List<Step> steps = new ArrayList<Step>();
		steps.add(new Step(300, "aaa"));
		steps.add(new Step(100, "bbb"));
		steps.add(new Step(500, "ccc"));
		steps.add(new Step(400, "ddd"));
		// 对集合对象进行排序
		ComparatorDemo comparator = new ComparatorDemo();
		Collections.sort(steps, comparator);
		//打印出已经排序的集合
		if (steps != null && steps.size() > 0) {
			for (Step step : steps) {
				System.out.print(step.getAcceptAddress() + " - ");
				System.out.println(step.getAcceptTime());
			}
		}

	}
}

class Step {
	/** 处理时间 */
	private long acceptTime = 0;
	/** 快件所在地点 */
	private String acceptAddress = "";

	public Step() {
		super();
	}

	public Step(long acceptTime, String acceptAddress) {
		super();
		this.acceptTime = acceptTime;
		this.acceptAddress = acceptAddress;
	}

	public long getAcceptTime() {
		return acceptTime;
	}

	public void setAcceptTime(long acceptTime) {
		this.acceptTime = acceptTime;
	}

	public String getAcceptAddress() {
		return acceptAddress;
	}

	public void setAcceptAddress(String acceptAddress) {
		this.acceptAddress = acceptAddress;
	}

}