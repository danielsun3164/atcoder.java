package other.hhkb2020;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 * 
 * https://atcoder.jp/contests/hhkb2020/submissions/17373712 にも参考
 */
public class ProblemE {

	private static final long MOD = 1_000_000_007L;

	/** 散らかっていないマスを表す文字 */
	private static final char OK = '.';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt();
			boolean[][] s = new boolean[h][w];
			int[][] t = new int[h][w];
			IntStream.range(0, h).forEach(i -> Arrays.fill(t[i], 0));
			// kと左、右からの連続の散らかっていないマスを計算
			int k = IntStream.range(0, h).map(i -> {
				char[] si = scanner.next().toCharArray();
				int ki = 0, count = 0;
				// kと左から計算
				for (int j = 0; j < w; j++) {
					s[i][j] = OK == si[j];
					ki += s[i][j] ? 1 : 0;
					// 最初の計算のみ ++countを使用
					t[i][j] += s[i][j] ? ++count : (count = 0);
				}
				count = 0;
				// 右から計算
				for (int j = w - 1; j >= 0; j--) {
					t[i][j] += (s[i][j]) ? count++ : (count = 0);
				}
				return ki;
			}).sum();
			// 上、下からの連続の散らかっていないマスを計算
			IntStream.range(0, w).forEach(j -> {
				int count = 0;
				// 上から計算
				for (int i = 0; i < h; i++) {
					t[i][j] += s[i][j] ? count++ : (count = 0);
				}
				count = 0;
				// 下から計算
				for (int i = h - 1; i >= 0; i--) {
					t[i][j] += s[i][j] ? count++ : (count = 0);
				}
			});
			// 結果を計算
			long result = powMod(2, k) * k % MOD;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (s[i][j]) {
						result = (result - powMod(2, k - t[i][j]) + MOD) % MOD;
					}
				}
			}
			System.out.println((result + MOD) % MOD);
		}

	}

	/**
	 * @param n
	 * @param m
	 * @return n^m mod MOD
	 */
	private static long powMod(long n, long m) {
		long result = 1L;
		while (m > 0) {
			if (1 == (m & 1)) {
				result = result * n % MOD;
			}
			n = n * n % MOD;
			m >>= 1;
		}
		return result;
	}
}
