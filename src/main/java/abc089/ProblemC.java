package abc089;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class ProblemC {

	/** 選ぶ人数 */
	private static final int N = 3;
	/** 対象となる頭文字 */
	private static final Set<Character> MARCHS = new HashSet<>(Arrays.asList('M', 'A', 'R', 'C', 'H'));

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Map<Character, Integer> map = new HashMap<>();
			IntStream.range(0, n).forEach(i -> {
				String s = scanner.next();
				char c = s.charAt(0);
				if (MARCHS.contains(c)) {
					map.put(c, map.getOrDefault(c, 0) + 1);
				}
			});
			int[] count = map.values().stream().mapToInt(Integer::intValue).toArray();
			System.out.println(IntStream.range((1 << N) - 1, (1 << count.length)).filter(i -> N == Integer.bitCount(i))
					.mapToLong(i -> IntStream.range(0, count.length).filter(j -> 0 != (i & (1 << j)))
							.mapToLong(j -> (long) count[j]).reduce(1L, (a, b) -> a * b))
					.sum());
		}
	}
}
