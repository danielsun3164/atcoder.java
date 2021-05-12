package abc.abc151_200.abc200;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemF {

	/** mod対象の数字 */
	private static final long MOD = 1_000_000_007L;
	/** ワイルドカード文字 */
	private static final char WILD_CARD = '?';
	/** 1/2 mod MOD */
	private static final long INV2 = inv(2L);

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			long k = scanner.nextLong();
			int n = s.length;
			if ((1L == k) && (1 == n)) {
				System.out.println(0);
				return;
			}
			int q = (int) IntStream.range(0, n).filter(i -> WILD_CARD == s[i]).count();
			long answer = ((IntStream.range(0, n).mapToLong(i -> f(s[i], s[(i + 1) % n])).sum() % MOD) * k) % MOD;
			answer = (((answer * powMod(2L, k * q)) % MOD) * INV2) % MOD;
			System.out.println(answer);
		}
	}

	/**
	 * 解説にあるf(a,b)の実装
	 *
	 * @param a
	 * @param b
	 * @return 解説にあるf(a,b)
	 */
	private static long f(char a, char b) {
		if ((WILD_CARD == a) || (WILD_CARD == b)) {
			return INV2;
		} else {
			return (a == b) ? 0L : 1L;
		}
	}

	/**
	 * xy≡1(mod MOD) なる y のうち、0≤y<MOD を満たすものを返します。
	 *
	 * @param x
	 * @return xy≡1(mod MOD) なる y のうち、0≤y<MOD を満たすもの
	 */
	private static long inv(long x) {
		return powMod(x, MOD - 2);
	}

	/**
	 * n^m mod MOD を計算する
	 *
	 * @param n
	 * @param m
	 * @return n^m mod MOD
	 */
	private static long powMod(long n, long m) {
		long result = 1L;
		while (m > 0) {
			if (1L == (1L & m)) {
				result = (result * n) % MOD;
			}
			n = (n * n) % MOD;
			m >>= 1;
		}
		return result;
	}
}
