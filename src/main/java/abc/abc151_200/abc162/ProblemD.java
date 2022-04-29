package abc.abc151_200.abc162;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class ProblemD {

	/** RGBの文字数 */
	private static final int N = 3;
	/** RGBの文字配列 */
	private static final char[] RGB = { 'R', 'G', 'B' };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			char[] s = scanner.next().toCharArray();
			Map<Character, Integer> map = new HashMap<>();
			IntStream.range(0, N).forEach(i -> map.put(RGB[i], i));
			@SuppressWarnings("unchecked")
			Set<Integer>[] sets = new Set[N];
			IntStream.range(0, N).forEach(i -> sets[i] = new HashSet<>());
			IntStream.range(0, n).forEach(i -> sets[map.get(s[i])].add(i + 1));
			long answer = sets[0].size() * (long) sets[1].size() * sets[2].size();
			System.out.println(answer - sets[0].stream()
					.mapToLong(ri -> sets[1].stream()
							.mapToLong(gi -> ((sets[2].contains(ri + ri - gi)) ? 1 : 0)
									+ ((sets[2].contains(gi + gi - ri)) ? 1 : 0)
									+ (((0 == ((ri ^ gi) & 1)) && sets[2].contains((ri + gi) >> 1)) ? 1 : 0))
							.sum())
					.sum());
		}
	}
}
