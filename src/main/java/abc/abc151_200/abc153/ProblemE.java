package abc.abc151_200.abc153;

import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class ProblemE {

	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), n = scanner.nextInt();
			SortedMap<Integer, Integer> map = new TreeMap<>();
			IntStream.range(0, n).forEach(i -> {
				int a = scanner.nextInt(), b = scanner.nextInt();
				map.put(a, Math.min(b, map.getOrDefault(a, INF)));
			});
			int[] dp = new int[h + map.lastKey()];
			Arrays.fill(dp, INF);
			dp[0] = 0;
			IntStream.range(0, h).filter(i -> dp[i] != INF).forEach(i -> map.entrySet().stream().forEach(
					entry -> dp[i + entry.getKey()] = Math.min(dp[i + entry.getKey()], dp[i] + entry.getValue())));
			System.out.println(IntStream.range(h, h + map.lastKey()).map(i -> dp[i]).min().getAsInt());
		}
	}
}
