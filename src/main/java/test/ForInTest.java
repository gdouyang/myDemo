package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ForInTest {

	public static void main(String[] args) {
		forin();
		arrayAndLinked();
	}

	private static void forin() {
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
	
	static void arrayAndLinked() {
		ArrayList<Integer> arrayList = new ArrayList<>();
		LinkedList<Integer> linkedList = new LinkedList<>();
		for (int i=0; i<10000; i++){
		    arrayList.add(i);
		    linkedList.add(i);
		}
		iteratorList(arrayList);
		forinList(arrayList);
		loopList(arrayList);

		iteratorList(linkedList);
		forinList(linkedList);
		loopList(linkedList);
	}
	
	static void loopList(List<Integer> lists){
		long startTime1=System.currentTimeMillis();   //获取开始时间
	    for (int i = 0; i < lists.size(); i++) {
	    	Integer integer = lists.get(i);
		}
	    long endTime1=System.currentTimeMillis(); //获取结束时间
		System.out.println("loop Time For "+ lists.getClass().getName() +"： "+(endTime1-startTime1)+"ms");
	}
	
	static void iteratorList(List<Integer> lists){
		long startTime1=System.currentTimeMillis();   //获取开始时间
	    Iterator<Integer> it = lists.iterator();
	    while (it.hasNext()){
	        Integer integer = it.next();
	    }
	    long endTime1=System.currentTimeMillis(); //获取结束时间
		System.out.println("iterator Time For "+ lists.getClass().getName() +"： "+(endTime1-startTime1)+"ms");
	}
	
	static void forinList(List<Integer> lists){
		long startTime1=System.currentTimeMillis();   //获取开始时间
	    for (Integer integ : lists) {
		}
	    long endTime1=System.currentTimeMillis(); //获取结束时间
		System.out.println("forin Time For "+ lists.getClass().getName() +"： "+(endTime1-startTime1)+"ms");
	}

}
