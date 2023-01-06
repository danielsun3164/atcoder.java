package other.typical90;

import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class Problem063 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt();
			int[][] p = new int[h][w];
			IntStream.range(0, h).forEach(i -> IntStream.range(0, w).forEach(j -> p[i][j] = scanner.nextInt()));
			System.out.println(IntStream.range(1, 1 << h).map(i -> {
				Map<Integer, Integer> map = new HashMap<>();
				return IntStream.range(0, w).map(j -> {
					NavigableMap<Integer, Integer> counter = new TreeMap<>();
					IntStream.range(0, h).filter(k -> 1 == (1 & (i >> k)))
							.forEach(k -> counter.put(p[k][j], counter.getOrDefault(p[k][j], 0) + 1));
					if (1 == counter.size()) {
						map.put(counter.firstKey(),
								map.getOrDefault(counter.firstKey(), 0) + counter.firstEntry().getValue());
						return map.get(counter.firstKey());
					} else {
						return 0;
					}
				}).max().getAsInt();
			}).max().getAsInt());
		}
	}
}
