package other.typical90;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem088 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), q = scanner.nextInt();
			int[] a = new int[n];
			int sum = IntStream.range(0, n).map(i -> a[i] = scanner.nextInt()).sum();
			Map<Integer, Set<Integer>> map = new HashMap<>();
			IntStream.range(0, q).forEach(i -> {
				int x = scanner.nextInt() - 1, y = scanner.nextInt() - 1;
				if (!map.containsKey(x)) {
					map.put(x, new HashSet<>());
				}
				map.get(x).add(y);
				if (!map.containsKey(y)) {
					map.put(y, new HashSet<>());
				}
				map.get(y).add(x);
			});
			@SuppressWarnings("unchecked")
			Set<Integer>[] sets = new Set[sum + 1];
			sets[0] = new TreeSet<>();
			for (int i = 0; i < n; i++) {
				Set<Integer> notSet = map.getOrDefault(i, Collections.<Integer>emptySet());
				for (int j = sum - a[i]; j >= 0; j--) {
					Set<Integer> nowSet = sets[j];
					if ((null != nowSet) && (0 == nowSet.stream().filter(y -> notSet.contains(y)).count())) {
						Set<Integer> newSet = new TreeSet<>(nowSet);
						newSet.add(i);
						if (null == sets[j + a[i]]) {
							sets[j + a[i]] = newSet;
						} else {
							System.out.println(newSet.size());
							System.out.println(
									newSet.stream().map(si -> String.valueOf(si + 1)).collect(Collectors.joining(" ")));
							System.out.println(sets[j + a[i]].size());
							System.out.println(sets[j + a[i]].stream().map(si -> String.valueOf(si + 1))
									.collect(Collectors.joining(" ")));
							return;
						}
					}
				}
			}
		}
	}
}
