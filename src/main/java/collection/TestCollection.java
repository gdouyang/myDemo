package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestCollection {
	public static void main(String[] args) {
		// testContains();
		// testSetAdd();
		// testHashMap();
		testHashSet();
	}

	public static void testSetAdd() {
		List<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("def");
		List<String> list2 = new ArrayList<String>();
		list2 = list;
		String str = list2.get(0);
		str = "aaaa";
		list2.set(0, str);
		// list2.add(str);
		System.out.println(list);
		System.out.println(list2);
	}

	public static void testContains() {
		List<InnerClassDemo> strs = new ArrayList<InnerClassDemo>();
		InnerClassDemo innerClassDemo = new InnerClassDemo();
		System.out.println(innerClassDemo.getSubAbc().getSs());
		;
		innerClassDemo.setStr("abc");
		strs.add(0, innerClassDemo);
		strs.add(0, innerClassDemo);
		strs.add(0, innerClassDemo);
		innerClassDemo.setStr("dd");
		InnerClassDemo aa = new InnerClassDemo();
		aa.setStr("ccc");
		strs.add(aa);
		if (strs.contains(innerClassDemo)) {// contains 如果List中有多个相同的对象，只比较最后一个
			strs.remove(innerClassDemo);
		}
		strs.add(innerClassDemo);
		System.out.println(strs);
	}

	public static void testHashMap() {
		Map<String, String> map = new HashMap<String, String>();
		String key = "123";
		String key1 = "1234";
		String value = "abc";
		String value1 = "abcd";
		map.put(key, value);//
		map.put(key, value1);// HashMap的key不能重复，如果重复之前添加的将被清除
		map.put(key1, value);// HashMap的Value可以重复
		map.put(key1, value1);
		System.out.println(map);
		System.out.println(map.size());
		System.out.println("HashMap的key不能重复，如果重复之前添加的将被清除,HashMap的Value可以重复");
	}

	public static void testHashSet() {
		Set<String> set = new HashSet<String>();//HashSet实际用的就是HashMap
		String one = "abc";
		String two = "abc";
		String three = "abcd";
		String four = new String("abc");
		set.add(one);
		set.add(two);
		set.add(three);
		set.add(four);
		System.out.println(set);
		System.out.println(set.size());
		System.out.println("set 里面不能添加重复数据会用==和equals同时对比，如果相同就不添加");
	}
}
