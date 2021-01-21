package abc.abc101_150.abc134;

import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = new int[n];
			TreeMap<Integer, Integer> map = new TreeMap<>();
			IntStream.range(0, n).forEach(i -> {
				a[i] = scanner.nextInt();
				map.put(a[i], map.getOrDefault(a[i], 0) + 1);
			});
			IntStream.range(0, n).forEach(i -> {
				Entry<Integer, Integer> lastEntry = map.lastEntry();
				if ((a[i] != lastEntry.getKey()) || (lastEntry.getValue() > 1)) {
					System.out.println(lastEntry.getKey());
				} else {
					// 最大のものをいったん削除
					map.pollLastEntry();
					System.out.println(map.lastKey());
					map.put(a[i], map.getOrDefault(a[i], 0) + 1);
				}
			});
		}
	}
}
