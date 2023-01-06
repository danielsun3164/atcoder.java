package other.typical90;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * 解説02の実装
 */
public class Problem059 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt(), q = scanner.nextInt();
			Path[] paths = IntStream.range(0, m).mapToObj(i -> new Path(scanner.nextInt() - 1, scanner.nextInt() - 1))
					.sorted((u, v) -> (u.y == v.y) ? Integer.compare(u.x, u.x) : Integer.compare(u.y, v.y))
					.toArray(Path[]::new);
			int[] a = new int[q], b = new int[q];
			IntStream.range(0, q).forEach(i -> {
				a[i] = scanner.nextInt() - 1;
				b[i] = scanner.nextInt() - 1;
			});
			// TLE対策のため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			long[] dp = new long[n];
			for (int i = 0; i * Long.SIZE < q; i++) {
				Arrays.fill(dp, 0L);
				for (int j = i * Long.SIZE; j < Math.min((i + 1) * Long.SIZE, q); j++) {
					dp[a[j]] |= 1L << (j - i * Long.SIZE);
				}
				IntStream.range(0, m).forEach(j -> dp[paths[j].y] |= dp[paths[j].x]);
				for (int j = i * Long.SIZE; j < Math.min((i + 1) * Long.SIZE, q); j++) {
					sb.append((1L == (1L & (dp[b[j]] >> (j - i * Long.SIZE)))) ? "Yes" : "No")
							.append(System.lineSeparator());
				}
			}
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * x,y を格納するクラス
	 */
	private static class Path {
		int x, y;

		Path(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
