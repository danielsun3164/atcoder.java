package other.math_and_algorithm;

import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class Problem082 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			NavigableMap<Integer, NavigableSet<Integer>> map = new TreeMap<>();
			IntStream.range(0, n).forEach(i -> {
				int l = scanner.nextInt(), r = scanner.nextInt();
				if (!map.containsKey(r)) {
					map.put(r, new TreeSet<>());
				}
				map.get(r).add(l);
			});
			int now = map.firstKey(), prevEnd = map.firstKey(), answer = 1;
			while (null != map.higherEntry(now)) {
				Entry<Integer, NavigableSet<Integer>> entry = map.higherEntry(now);
				if (null != entry.getValue().ceiling(prevEnd)) {
					prevEnd = entry.getKey();
					answer++;
				}
				now = entry.getKey();
			}
			System.out.println(answer);
		}
	}
}
