package abc.abc201_250.abc233;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long x = scanner.nextLong();
			int[] l = new int[n];
			long[][] a = new long[n][];
			IntStream.range(0, n).forEach(i -> {
				l[i] = scanner.nextInt();
				a[i] = IntStream.range(0, l[i]).mapToLong(j -> scanner.nextLong()).toArray();
			});
			Map<Long, Integer> map = new HashMap<>();
			for (int i = 0; i < l[0]; i++) {
				if (0L == x % a[0][i]) {
					map.put(x / a[0][i], map.getOrDefault(x / a[0][i], 0) + 1);
				}
			}
			for (int i = 1; i < n; i++) {
				Map<Long, Integer> newMap = new HashMap<>();
				for (Entry<Long, Integer> entry : map.entrySet()) {
					for (long aij : a[i]) {
						if (0L == entry.getKey() % aij) {
							newMap.put(entry.getKey() / aij,
									newMap.getOrDefault(entry.getKey() / aij, 0) + entry.getValue());
						}
					}
				}
				map = newMap;
			}
			System.out.println(map.getOrDefault(1L, 0));
		}
	}
}
