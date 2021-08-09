package abc.abc201_250.abc203;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			int[][] a = new int[n][n];
			int aMax = IntStream.range(0, n)
					.map(i -> IntStream.range(0, n).map(j -> a[i][j] = scanner.nextInt()).max().getAsInt()).max()
					.getAsInt();
			int ok = aMax, ng = -1;
			while (ok > (ng + 1)) {
				int med = (ok + ng) >> 1;
				if (ok(n, k, a, med)) {
					ok = med;
				} else {
					ng = med;
				}
			}
			System.out.println(ok);
		}
	}

	/**
	 * n×nのマスの中のk×kの区画に中央値がx以下の区画があるかを計算する
	 *
	 * @param n
	 * @param k
	 * @param a
	 * @param x
	 * @return n×nのマスの中のk×kの区画に中央値がx以下の区画があるか
	 */
	private static boolean ok(int n, int k, int[][] a, int x) {
		int m = ((k * k) / 2) + 1;
		int[][] s = new int[n + 1][n + 1];
		Arrays.fill(s[0], 0);
		IntStream.rangeClosed(0, n).forEach(i -> s[i][0] = 0);
		IntStream.range(0, n).forEach(i -> IntStream.range(0, n)
				.forEach(j -> s[i + 1][j + 1] = ((s[i][j + 1] + s[i + 1][j]) - s[i][j]) + ((a[i][j] > x) ? 1 : 0)));
		for (int i = k; i <= n; i++) {
			for (int j = k; j <= n; j++) {
				if (((s[i][j] - s[i - k][j] - s[i][j - k]) + s[i - k][j - k]) < m) {
					return true;
				}
			}
		}
		return false;
	}
}
