package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("a", "a", "b", "b", "c");
		/*
		 * Map<String, List<String>> collect =
		 * list.stream().collect(Collectors.groupingBy(new Function<String, String>() {
		 * 
		 * @Override public String apply(String t) { return t; } }));
		 * collect.forEach((str, li) -> { System.out.println(str + ":" + li.size()); });
		 */
		System.out.println("<-------------->");
		list = Arrays.asList("a", "a", "b", "b", "a");
		// collect = list.stream().collect(Collectors.groupingBy((a) -> a.toString()));
		// collect = list.stream().collect(String::toString);
		Map<String, Long> collect1 = list.stream()
				.collect(Collectors.groupingBy(v -> v, Collectors.counting()));
		collect1.forEach((str, li) -> {
			System.out.println(str + ":" + li);
		});
		System.out.println("<-------------->");
		Map<String, Long> map = new HashMap<>();
		map.put("a", 1L);
		Collector<Long, ?, Long> counting = Collectors.reducing(0L, new Function<Long, Long>() {
			@Override
			public Long apply(Long t) {
				return t;
			}
		}, Long::sum);
		Supplier<?> supplier = counting.supplier();
		BiConsumer<Map<String, Long>, Long> accumulator = (m, t) -> {
			Long computeIfAbsent = map.computeIfAbsent("b", a -> {
				Object container = supplier.get();
				return 1L;
			});
		};
		accumulator.accept(map, 1L);

		List<Integer> nums = Arrays.asList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);
		List<Integer> numsWithoutNull = nums.stream().filter(num -> num != null).collect(() -> new ArrayList<Integer>(),
				(list1, item) -> list1.add(item), (list1, list2) -> list1.addAll(list2));

		System.out.println("<-------------->");
		Random seed = new Random();
		Supplier<Integer> random = seed::nextInt;
		Stream.generate(random).limit(10).forEach(System.out::println);
		// Another way
		IntStream.generate(() -> (int) (System.nanoTime() % 100)).limit(10).forEach(System.out::println);
	}

}
