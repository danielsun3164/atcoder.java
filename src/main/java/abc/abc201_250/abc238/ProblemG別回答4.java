package abc.abc201_250.abc238;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc238/editorial/6029 の実装<br/>
 * https://atcoder.jp/contests/abc238/submissions/29102150 にも参考</br>
 * TLE対策のため、StreamAPIのかわりにfor文を利用
 */
public class ProblemG別回答4 {

	/** MOD対象数字の配列 */
	private static final long[] P = { 186404389L, 911312767L, 411870757L, 76387417L, 208030723L, 145301809L, 32126053L,
			122673997L, 902277199L, 451850629L, 616263829L, 688167721L, 508768417L, 363019753L, 961479853L, 476710879L,
			726825403L, 491004991L, 994708321L, 618737551L, 582806911L, 229870567L, 347870947L, 718705159L,
			589793389L };
	/** 3 */
	private static final int N = 3;
	/** 25ではTLEになるため、15に修正 */
	private static final int M = 15;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), q = scanner.nextInt();
			long[][] b = new long[n + 1][M];
			IntStream.rangeClosed(0, n).forEach(i -> Arrays.fill(b[i], 0L));
			IntStream.range(0, M).forEach(i -> b[0][i] = 1L);
			for (int i = 0; i < n; i++) {
				int a = scanner.nextInt();
				for (int j = 0; j < M; j++) {
					b[i + 1][j] = b[i][j] * a % P[j];
				}
			}
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < q; i++) {
				int l = scanner.nextInt(), r = scanner.nextInt();
				boolean c = true;
				for (int j = 0; j < M; j++) {
					long x = b[r][j] * powMod(b[l - 1][j], P[j] - 2, P[j]) % P[j];
					if (powMod(x, (P[j] - 1) / N, P[j]) > 1L) {
						c = false;
					}
				}
				sb.append(c ? "Yes" : "No").append(System.lineSeparator());
			}
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * n^m MOD modを計算する
	 *
	 * @param n
	 * @param m
	 * @param mod
	 * @return n^m MOD mod
	 */
	private static long powMod(long n, long m, long mod) {
		long result = 1L;
		while (m > 0) {
			if (1 == (1 & m)) {
				result = (result * n) % mod;
			}
			n = (n * n) % mod;
			m >>= 1;
		}
		return result;
	}
}
