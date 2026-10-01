package abc.abc201_250.abc243;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	/** 右向きを表す文字 */
	private static final char RIGHT = 'R';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] x = new int[n], y = new int[n];
			IntStream.range(0, n).forEach(i -> {
				x[i] = scanner.nextInt();
				y[i] = scanner.nextInt();
			});
			char[] s = scanner.next().toCharArray();
			Map<Integer, Integer> rMap = new HashMap<>(), lMap = new HashMap<>();
			IntStream.range(0, n).forEach(i -> {
				if (RIGHT == s[i]) {
					rMap.put(y[i], Math.min(rMap.getOrDefault(y[i], Integer.MAX_VALUE), x[i]));
				} else {
					lMap.put(y[i], Math.max(lMap.getOrDefault(y[i], Integer.MIN_VALUE), x[i]));
				}
			});
			for (Entry<Integer, Integer> entry : rMap.entrySet()) {
				if ((lMap.containsKey(entry.getKey())) && (entry.getValue() < lMap.get(entry.getKey()))) {
					System.out.println("Yes");
					return;
				}
			}
			System.out.println("No");
		}
	}
}
