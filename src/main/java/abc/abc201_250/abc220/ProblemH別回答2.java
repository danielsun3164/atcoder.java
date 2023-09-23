package abc.abc201_250.abc220;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc220/editorial/2708 解法の実装<br/>
 * https://atcoder.jp/contests/abc220/submissions/26221330 にも参考<br/>
 * 注意：提出するとTLEになる場合もあるため、ACになるまで繰り返し提出すること
 */
public class ProblemH別回答2 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			boolean[][] e = new boolean[n][n];
			IntStream.range(0, m).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				e[a][b] = e[b][a] = true;
			});
			int n1 = n >> 1;
			int[] counts1 = new int[1 << n1];
			long[][] d1 = new long[2][1 << n1];
			IntStream.range(0, 1 << n1).forEach(bit -> {
				int count = 0, k = Integer.numberOfTrailingZeros(bit);
				if (bit > 0) {
					count = counts1[bit ^ (1 << k)];
					for (int i = 0; i < n1; i++) {
						if (e[k][i] && ((i < k) || (0 == ((bit >> i) & 1)))) {
							count++;
						}
					}
					for (int i = n1; i < n; i++) {
						if (e[k][i]) {
							count++;
						}
					}
				}
				d1[1 & count][bit]++;
				counts1[bit] = count;
			});

			int n2 = n - n1;
			int[] counts2 = new int[1 << n2], ss = new int[1 << n2];
			long[][] d2 = new long[2][1 << n2];
			IntStream.range(0, 1 << n2).forEach(bit -> {
				int count = 0, s = 0, k = Integer.numberOfTrailingZeros(bit);
				if (bit > 0) {
					count = counts2[bit ^ (1 << k)];
					s = ss[bit ^ (1 << k)];
					for (int i = 0; i < n1; i++) {
						if (e[k + n1][i]) {
							count++;
							s ^= 1 << i;
						}
					}
					for (int i = n1; i < n; i++) {
						if (e[k + n1][i] && ((i < (n1 + k)) || (0 == ((bit >> (i - n1)) & 1)))) {
							count++;
						}
					}
				}
				d2[1 & count][s]++;
				counts2[bit] = count;
				ss[bit] = s;
			});
			long answer = 0L;
			// TLE対応のため、IntStreamの代わりにfor文を使用
			for (int f1 = 0; f1 < 2; f1++) {
				for (int f2 = 0; f2 < 2; f2++) {
					long[] p = andConv(n1, d1[f1], d2[f2]);
					for (int i = 0; i < (1 << n1); i++) {
						if (0 == ((f1 + f2 + Integer.bitCount(i)) & 1)) {
							answer += p[i];
						}
					}
				}
			}
			System.out.println(answer);
		}
	}

	/**
	 * g(S)=Σ[S\subset T]f(T)のとき、fからgを作る
	 *
	 * @param n
	 * @param dp f
	 * @return 作成されたg
	 */
	private static long[] ueZeta(int n, long[] dp) {
		long[] p = Arrays.copyOf(dp, 1 << n);
		IntStream.range(0, n).forEach(
				i -> IntStream.range(0, 1 << n).filter(j -> 0 == ((j >> i) & 1)).forEach(j -> p[j] += p[j ^ (1 << i)]));
		return p;
	}

	/**
	 * g(S)=Σ[S\subset T]f(T)のとき、gからfを作る
	 *
	 * @param n
	 * @param dp g
	 */
	private static void ueMebiusu(int n, long[] dp) {
		IntStream.range(0, n).forEach(i -> IntStream.range(0, 1 << n).filter(j -> 0 == ((j >> i) & 1))
				.forEach(j -> dp[j] -= dp[j ^ (1 << i)]));
	}

	/**
	 * g(x)=Σ[k1&k2=x]f1(k1)f2(k2)のとき、fからgをつくる
	 *
	 * @param n
	 * @param dp1
	 * @param dp2
	 * @return 作られたg
	 */
	private static long[] andConv(int n, long[] dp1, long[] dp2) {
		long[] p = new long[1 << n];
		dp1 = ueZeta(n, dp1);
		if (!Arrays.equals(dp1, dp2)) {
			dp2 = ueZeta(n, dp2);
		}
		for (int i = 0; i < (1 << n); i++) {
			p[i] = dp1[i] * dp2[i];
		}
		ueMebiusu(n, p);
		return p;
	}
}
