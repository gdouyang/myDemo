package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class StreamTest2 {
	public static void main(String[] args) {
		List<Integer> values = Arrays.asList(100, 300, 400, 500, 600, 500);
		List<Integer> setps = Arrays.asList(200, 300, 400, 500);

		setps.forEach(step -> {
			long count = values.stream().filter(value -> value >= step).count();
			System.out.println(step + "->" + count);
		});
		System.out.println("-----------");
		method2(values, setps);
		System.out.println("-----------");
		method1(values, setps);
	}

	private static void method2(List<Integer> list, List<Integer> setps) {
		Map<Integer, List<Integer>> maps = new LinkedHashMap<>();
		setps.forEach(value -> maps.put(value, list));

		for (Entry<Integer, List<Integer>> step : maps.entrySet()) {
			Integer st = step.getKey();
			List<Integer> newList = step.getValue().stream().filter(value -> value >= st).collect(Collectors.toList());
			maps.put(st, newList);
		}
		maps.forEach((key, value) -> {
			System.out.println(key + "->" + value.size());
		});
	}

	private static void method1(List<Integer> list, List<Integer> setps) {
		List<Map<Integer, List<Integer>>> collect = setps.stream().map(v -> {
			Map<Integer, List<Integer>> map = new HashMap<>();
			map.put(v, list);
			return map;
		}).filter(map -> {
			for (Entry<Integer, List<Integer>> step : map.entrySet()) {
				Integer st = step.getKey();
				List<Integer> li1 = new ArrayList<>();
				step.getValue().forEach(v1 -> {
					if (v1 >= st) {
						li1.add(v1);
					}
				});
				map.put(st, li1);
			}
			return true;
		}).collect(Collectors.toList());
		collect.forEach(map -> map.forEach((key, value) -> {
			System.out.println(key + "-" + value.size());
		}));
	}
}
