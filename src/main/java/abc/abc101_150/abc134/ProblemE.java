package abc.abc101_150.abc134;

import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			TreeMap<Integer, Integer> map = new TreeMap<>();
			IntStream.range(0, n).forEach(i -> {
				Entry<Integer, Integer> entry = map.lowerEntry(a[i]);
				if (null != entry) {
					if (1 == entry.getValue()) {
						map.remove(entry.getKey());
					} else {
						map.put(entry.getKey(), entry.getValue() - 1);
					}
				}
				map.put(a[i], map.getOrDefault(a[i], 0) + 1);
			});
			System.out.println(map.values().stream().mapToInt(Integer::intValue).sum());
		}
	}
}
