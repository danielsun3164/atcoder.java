package abc.abc201_250.abc248;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc248/editorial/3792 の実装
 */
public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			long[] x = new long[n], y = new long[n];
			IntStream.range(0, n).forEach(i -> {
				x[i] = scanner.nextLong();
				y[i] = scanner.nextLong();
			});
			if (1 == k) {
				System.out.println("Infinity");
				return;
			}
			boolean[][] flag = new boolean[n][n];
			IntStream.range(0, n).forEach(i -> Arrays.fill(flag[i], true));
			int answer = 0;
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					if (flag[i][j]) {
						int count = 2;
						List<Integer> list = new ArrayList<>();
						list.add(i);
						list.add(j);
						for (int l = j + 1; l < n; l++) {
							if (colinear(x, y, i, j, l)) {
								count++;
								list.add(l);
							}
						}
						for (int l = 0; l < count; l++) {
							for (int ll = l + 1; ll < count; ll++) {
								flag[list.get(l)][list.get(ll)] = false;
							}
						}
						if (count >= k) {
							answer++;
						}
					}
				}
			}
			System.out.println(answer);
		}
	}

	/**
	 * a,b,cの座標が同じ直線上にあるかを判定する
	 *
	 * @param x X座標一覧
	 * @param y Y座標一覧
	 * @param a
	 * @param b
	 * @param c
	 * @return a,b,cの座標が同じ直線上にあるか
	 */
	private static boolean colinear(long[] x, long[] y, int a, int b, int c) {
		long value1 = (y[b] - y[a]) * (x[c] - x[a]), value2 = (x[b] - x[a]) * (y[c] - y[a]);
		return value1 == value2;
	}
}
