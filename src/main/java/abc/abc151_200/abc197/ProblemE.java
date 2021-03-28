package abc.abc151_200.abc197;

import java.util.Scanner;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			SortedMap<Integer, SortedSet<Integer>> map = new TreeMap<>();
			IntStream.range(0, n).forEach(i -> {
				int x = scanner.nextInt(), c = scanner.nextInt();
				SortedSet<Integer> set = map.get(c);
				if (null == set) {
					set = new TreeSet<>();
					map.put(c, set);
				}
				set.add(x);
			});
			// coord[i][0]は色iの最小座標、coord[i][1]は色iの最大座標
			int[][] coord = new int[n + 1][2];
			coord[0][0] = coord[0][1] = 0;
			IntStream.rangeClosed(1, n).forEach(i -> {
				if (map.containsKey(i)) {
					coord[i][0] = map.get(i).first();
					coord[i][1] = map.get(i).last();
				} else {
					coord[i][0] = coord[i - 1][0];
					coord[i][1] = coord[i - 1][1];
				}
			});
			// dp[i][0]は色iの最小座標まで収集した結果、dp[i][1]は色iの最大座標まで収集した結果
			long[][] dp = new long[n + 1][2];
			dp[0][0] = dp[0][1] = 0L;
			IntStream.rangeClosed(1, n).forEach(i -> {
				if (map.containsKey(i)) {
					dp[i][0] = Math.min(
							dp[i - 1][0] + Math.abs(coord[i][1] - coord[i - 1][0]) + (coord[i][1] - coord[i][0]),
							dp[i - 1][1] + Math.abs(coord[i][1] - coord[i - 1][1]) + (coord[i][1] - coord[i][0]));
					dp[i][1] = Math.min(
							dp[i - 1][0] + Math.abs(coord[i][0] - coord[i - 1][0]) + (coord[i][1] - coord[i][0]),
							dp[i - 1][1] + Math.abs(coord[i][0] - coord[i - 1][1]) + (coord[i][1] - coord[i][0]));
				} else {
					dp[i][0] = dp[i - 1][0];
					dp[i][1] = dp[i - 1][1];
				}
			});
			System.out.println(Math.min(dp[n][0] + Math.abs(coord[n][0]), dp[n][1] + Math.abs(coord[n][1])));
		}
	}
}
