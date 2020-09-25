package abc.abc127;

import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			SortedMap<Integer, Integer> map = new TreeMap<>();
			IntStream.range(0, n).forEach(i -> {
				int a = scanner.nextInt();
				map.put(a, map.getOrDefault(a, 0) + 1);
			});
			IntStream.range(0, m).forEach(i -> {
				int b = scanner.nextInt(), c = scanner.nextInt();
				while ((b > 0) && (map.firstKey() < c)) {
					int exists = map.get(map.firstKey());
					if (exists > b) {
						map.put(map.firstKey(), exists - b);
						map.put(c, map.getOrDefault(c, 0) + b);
						b = 0;
					} else {
						map.put(c, map.getOrDefault(c, 0) + exists);
						map.remove(map.firstKey());
						b -= exists;
					}
				}
			});
			System.out.println(
					map.entrySet().stream().mapToLong(entry -> entry.getKey() * (long) entry.getValue()).sum());
		}
	}
}
