package abc.abc201_250.abc221;

import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			NavigableMap<Long, Integer> map = new TreeMap<>();
			IntStream.range(0, n).forEach(i -> {
				long a = scanner.nextLong(), b = scanner.nextLong();
				map.put(a, map.getOrDefault(a, 0) + 1);
				map.put(a + b, map.getOrDefault(a + b, 0) - 1);
			});
			long preKey = 0L;
			int preValue = 0;
			long[] answers = new long[n + 1];
			for (Entry<Long, Integer> entry : map.entrySet()) {
				answers[preValue] += entry.getKey() - preKey;
				preValue += entry.getValue();
				preKey = entry.getKey();
			}
			System.out.println(IntStream.rangeClosed(1, n).mapToLong(i -> answers[i]).mapToObj(String::valueOf)
					.collect(Collectors.joining(" ")));
		}
	}
}
