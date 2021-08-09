package abc.abc151_200.abc200;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc200/submissions/22378297 にも参考
 */
public class ProblemF別回答 {

	/** mod対象の数字 */
	private static final long MOD = 1_000_000_007L;
	/** 0文字 */
	private static final char ZERO = '0';
	/** 1文字 */
	private static final char ONE = '1';
	/** ワイルドカード文字 */
	private static final char WILD_CARD = '?';
	/** 0のときの行列 */
	private static final long[][] ZERO_MATRIX = { { 1, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0 }, { 0, 0, 0, 1, 1 },
			{ 0, 0, 0, 1, 0 }, { 0, 0, 0, 0, 1 } };
	/** 1のときの行列 */
	private static final long[][] ONE_MATRIX = { { 0, 1, 0, 0, 1 }, { 0, 1, 0, 0, 0 }, { 0, 0, 1, 0, 0 },
			{ 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 1 } };
	/** ?のときの行列 */
	private static final long[][] WILD_CARD_MATRIX = { { 1, 1, 0, 0, 1 }, { 1, 1, 0, 0, 0 }, { 0, 0, 1, 1, 1 },
			{ 0, 0, 1, 1, 0 }, { 0, 0, 0, 0, 2 } };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			int k = scanner.nextInt(), n = s.length;
			long[][] m = pow(ZERO_MATRIX, 0);
			for (int i = 1; i < n; i++) {
				m = multiply(m, char2matrix(s[i]));
			}
			m = multiply(m, pow(multiply(char2matrix(s[0]), m), k - 1));
			long answer = 0;
			if (ZERO != s[0]) {
				answer = (answer + m[2][4]) % MOD;
			}
			if (ONE != s[0]) {
				answer = (answer + m[0][4]) % MOD;
			}
			System.out.println(answer);
		}
	}

	/**
	 * 文字に対応する行列を返す
	 *
	 * @param c 文字
	 * @return 文字に対応する行列
	 */
	private static long[][] char2matrix(char c) {
		return (WILD_CARD == c) ? WILD_CARD_MATRIX : ((ONE == c) ? ONE_MATRIX : ZERO_MATRIX);
	}

	/**
	 * 行列aと行列bの掛け算を行う
	 *
	 * @param a
	 * @param b
	 * @return 行列aと行列bの掛け算の結果
	 */
	private static long[][] multiply(long[][] a, long[][] b) {
		long[][] result = new long[a.length][b[0].length];
		IntStream.range(0, result.length).forEach(i -> Arrays.fill(result[i], 0L));
		IntStream.range(0, a.length).forEach(i -> IntStream.range(0, result[i].length).forEach(j -> IntStream
				.range(0, a[i].length).forEach(k -> result[i][j] = (result[i][j] + (a[i][k] * b[k][j])) % MOD)));
		return result;
	}

	/**
	 * 行列mのk乗を計算する
	 *
	 * @param m 行列を表す配列
	 * @param k
	 * @return 行列mのk乗
	 */
	private static long[][] pow(long[][] m, int k) {
		long[][] result = new long[m.length][m.length];
		for (int i = 0; i < result.length; i++) {
			Arrays.fill(result[i], 0L);
			result[i][i] = 1L;
		}
		while (k > 0) {
			if (1 == (1 & k)) {
				result = multiply(result, m);
			}
			m = multiply(m, m);
			k >>= 1;
		}
		return result;
	}
}
