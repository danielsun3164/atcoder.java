package abc.abc201_250.abc203;

import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			SortedMap<Integer, Set<Integer>> map = new TreeMap<>();
			IntStream.range(0, m).forEach(i -> {
				int x = scanner.nextInt(), y = scanner.nextInt();
				Set<Integer> set = map.get(x);
				if (null == set) {
					set = new HashSet<>();
					map.put(x, set);
				}
				set.add(y);
			});
			Set<Integer> now = new HashSet<>();
			now.add(n);
			Set<Integer> add = new HashSet<>(), remove = new HashSet<>();
			for (Entry<Integer, Set<Integer>> entry : map.entrySet()) {
				for (int y : entry.getValue()) {
					if (now.contains(y - 1) || now.contains(y + 1)) {
						add.add(y);
					} else if (now.contains(y)) {
						remove.add(y);
					}
				}
				now.addAll(add);
				now.removeAll(remove);
				add.clear();
				remove.clear();
			}
			System.out.println(now.size());
		}
	}
}
