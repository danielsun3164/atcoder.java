package abc.abc201_250.abc229;

import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long w = scanner.nextLong();
			NavigableMap<Long, Long> map = new TreeMap<>();
			IntStream.range(0, n).forEach(i -> {
				long a = scanner.nextLong(), b = scanner.nextLong();
				map.put(a, map.getOrDefault(a, 0L) + b);
			});
			long answer = 0L;
			while ((w > 0L) && !map.isEmpty()) {
				Entry<Long, Long> entry = map.pollLastEntry();
				answer += Math.min(w, entry.getValue()) * entry.getKey();
				w -= Math.min(w, entry.getValue());
			}
			System.out.println(answer);
		}
	}
}
