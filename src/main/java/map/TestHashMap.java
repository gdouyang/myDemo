package map;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {
public static void main(String[] args) {
	//在HashMap中的put方法中打断点
	Map<String, Integer> map = new HashMap<String, Integer>();
	//内部一个 Entry[] table 用来存内容，其中Entry是HashMap中的一个内部类里面有key，value两个字段
	map.put("num", 123);
	
}
}
