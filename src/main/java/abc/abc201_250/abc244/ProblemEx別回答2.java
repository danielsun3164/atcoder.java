package abc.abc201_250.abc244;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc244/editorial/3628 の実装<br/>
 * https://atcoder.jp/contests/abc244/submissions/30312031 にも参考
 */
public class ProblemEx別回答2 {

	/** 最大値 */
	private static final long INF = Long.MAX_VALUE;
	private static final int D = 1000;
	private static long[] X, Y, A, B;

	/**
	 * C++の _2d_comp() を移植。
	 */
	private static boolean comp2d(long lx, long ly, long rx, long ry) {
		if (lx == 0 && rx == 0) {
			return false;
		}
		if (lx == 0) {
			return ly > 0 || rx < 0;
		}
		if (rx == 0) {
			return !(ry > 0 || lx < 0);
		}
		if ((lx < 0) ^ (rx < 0)) {
			return lx > 0;
		}
		return lx * ry < ly * rx;
	}

	/**
	 * C++の det() を移植。
	 */
	private static boolean det(long ax, long ay, long bx, long by, long cx, long cy) {
		ax -= bx;
		ay -= by;
		bx -= cx;
		by -= cy;
		return 0 < ax * by - ay * bx;
	}

	public static void main(String[] args) throws Exception {
		try (Scanner scanner = new Scanner(System.in)) {
			int q = scanner.nextInt();
			X = new long[q];
			Y = new long[q];
			A = new long[q];
			B = new long[q];
			IntStream.range(0, q).forEach(i -> {
				X[i] = scanner.nextLong();
				Y[i] = scanner.nextLong();
				A[i] = scanner.nextLong();
				B[i] = scanner.nextLong();
			});

			// C++の sort(order, ...) と同じく X、次にYで昇順ソート
			Integer[] order = IntStream.range(0, q).boxed().toArray(Integer[]::new);
			Arrays.sort(order, (l, r) -> (X[l] != X[r]) ? Long.compare(X[l], X[r]) : Long.compare(Y[l], Y[r]));

			int[] conv = new int[2 * q];
			int convSize = 0;

			// TLE対策のため、結果をStringBuilderにまとめる
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < q; i++) {
				if (i != 0 && i % D == 0) {
					int k = 0;
					// 下側の凸包を構築
					for (int j = 0; j < q; j++) {
						int a = order[j];
						if (a >= i) {
							continue;
						}

						while (k > 1
								&& det(X[conv[k - 2]], Y[conv[k - 2]], X[conv[k - 1]], Y[conv[k - 1]], X[a], Y[a])) {
							k--;
						}
						conv[k++] = a;
					}

					int t = k, J = 1;
					// 上側の凸包を構築
					for (int j = 0; j < q; j++) {
						int a = order[q - j - 1];
						if (a >= i) {
							continue;
						}

						if (J != 0) {
							J = 0;
							continue;
						}

						while (k > t
								&& det(X[conv[k - 2]], Y[conv[k - 2]], X[conv[k - 1]], Y[conv[k - 1]], X[a], Y[a])) {
							k--;
						}
						conv[k++] = a;
					}
					convSize = k;
				}
				if ((A[i] == 0) && (B[i] == 0)) {
					sb.append("0").append(System.lineSeparator());
					continue;
				}

				long answer = -INF;
				// 直近のブロックを全探索
				for (int j = (i / D) * D; j <= i; j++) {
					answer = Math.max(answer, X[j] * A[i] + Y[j] * B[i]);
				}
				if (i < D) {
					sb.append(answer).append(System.lineSeparator());
					continue;
				}
				int l = -1, r = convSize - 1;
				answer = Math.max(answer, X[conv[r - 1]] * A[i] + Y[conv[r - 1]] * B[i]);
				// 凸包上で最大値を取る点を二分探索
				while (r - l > 1) {
					int med = (l + r) / 2;
					if (comp2d(B[i], -A[i], X[conv[med + 1]] - X[conv[med]], Y[conv[med + 1]] - Y[conv[med]])) {
						r = med;
					} else {
						l = med;
					}
				}
				answer = Math.max(answer, X[conv[r]] * A[i] + Y[conv[r]] * B[i]);
				answer = Math.max(answer, X[conv[0]] * A[i] + Y[conv[0]] * B[i]);
				sb.append(answer).append(System.lineSeparator());
			}
			System.out.print(sb);
		}
	}
}
