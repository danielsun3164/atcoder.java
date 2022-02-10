package abc.abc151_200.abc155;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Map<String, Integer> map = new HashMap<>();
			IntStream.range(0, n).forEach(i -> {
				String s = scanner.next();
				map.put(s, map.getOrDefault(s, 0) + 1);
			});
			int max = map.values().stream().max((a, b) -> a.compareTo(b)).get();
			// TLE対策のため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			map.entrySet().stream().filter(entry -> max == entry.getValue()).map(Entry::getKey).sorted()
					.forEach(key -> sb.append(key).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
