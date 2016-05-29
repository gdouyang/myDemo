package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ForInTest {

	public static void main(String[] args) {
		List<String> strs = new ArrayList<String>(0);
		// 往集合中放入对象
		for (int j = 0; j < 5; j++) {
			strs.add("字母 " + j);
		}
		System.out.println(strs);
		// 用迭代器不会出现Exception
		for (Iterator<String> iterator = strs.iterator(); iterator.hasNext();) {
			String s = iterator.next();
			if (s.equals("字母 1")) {
				// str = "abc";
				iterator.remove();
			}
		}
		// 使用For In 模式的遍历会出现Exception
		// 如果 list 的 size == 2 的话，不会拋出异常，
		// 这个模式会隐式调用AbstractList中迭代器的checkForComodification()方法,
		for (String a : strs) {
			if (a.equals("字母 1")) {
				// a = "bcd";
				strs.remove(0);
			}
		}
		System.out.println(strs);

	}

}
