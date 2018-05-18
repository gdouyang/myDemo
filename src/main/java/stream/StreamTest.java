package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamTest {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("a", "a", "b", "b", "c");
		Map<String, List<String>> collect = list.stream().collect(Collectors.groupingBy(new Function<String, String>() {

			@Override
			public String apply(String t) {
				return t;
			}
		}));
		collect.forEach((str, li) -> {
			System.out.println(str + ":" + li.size());
		});
		list = Arrays.asList("a", "a", "b", "b", "a");
		// collect = list.stream().collect(Collectors.groupingBy((a) -> a.toString()));
		// collect = list.stream().collect(String::toString);
		Map<String, Long> collect1 = list.stream()
				.collect(Collectors.groupingBy(String::toString, Collectors.counting()));
		collect1.forEach((str, li) -> {
			System.out.println(str + ":" + li);
		});
	}
}
