package abc.abc201_250.abc230;

import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long d = scanner.nextLong();
			NavigableMap<Long, NavigableSet<Long>> lMap = new TreeMap<>(), rMap = new TreeMap<>();
			IntStream.range(0, n).forEach(i -> {
				long l = scanner.nextLong(), r = scanner.nextLong();
				if (!lMap.containsKey(l)) {
					lMap.put(l, new TreeSet<>());
				}
				lMap.get(l).add(r);
				if (!rMap.containsKey(r)) {
					rMap.put(r, new TreeSet<>());
				}
				rMap.get(r).add(l);
			});
			int answer = 0;
			while (!rMap.isEmpty()) {
				Entry<Long, NavigableSet<Long>> entry = rMap.firstEntry();
				long max = entry.getKey() + d - 1;
				while ((!lMap.isEmpty()) && (lMap.firstKey() <= max)) {
					Entry<Long, NavigableSet<Long>> lEntry = lMap.pollFirstEntry();
					for (long lr : lEntry.getValue()) {
						NavigableSet<Long> set = rMap.get(lr);
						set.remove(lEntry.getKey());
						if (set.isEmpty()) {
							rMap.remove(lr);
						}
					}
				}
				answer++;
			}
			System.out.println(answer);
		}
	}
}
