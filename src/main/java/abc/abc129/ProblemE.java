package abc.abc129;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemE {

	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			// one[i]はs[i]の前の1の数
			int[] one = new int[s.length];
			one[0] = 0;
			IntStream.range(1, s.length).forEach(i -> one[i] = one[i - 1] + (('1' == s[i - 1]) ? 1 : 0));
			long answer = f(s.length);
			for (int i = s.length - 1; i >= 0; i--) {
				if ('0' == s[i]) {
					// r(i)を場所iの右側の文字列の長さとすると、
					// s[i]が0の場合、2^s[i]の前の1の数×（f(r(i)+1）-f(r(i)) をanswerから引く
					answer = safeMod(answer - safeMod(powMod(2, one[i]) * (f(s.length - i) - f(s.length - i - 1))));
				}
			}
			System.out.println(answer);
		}
	}

	/**
	 * 長さnのすべてが1の文字列の回答を計算する
	 * 
	 * @param n 文字列の長さ
	 * @return 長さnのすべてが1の文字列の回答
	 */
	private static long f(int n) {
		return powMod(3L, n);
	}

	/**
	 * x^n mod MOD
	 * 
	 * @param x
	 * @param n
	 * @return x^n mod MOD を計算する
	 */
	static long powMod(long x, long n) {
		return powMod(x, n, MOD);
	}

	/**
	 * x^n mod m
	 * 
	 * @param x
	 * @param n
	 * @param m
	 * @return x^n mod m を計算する
	 */
	static long powMod(long x, long n, long m) {
		if (!((0L <= n) || (1L <= m))) {
			throw new IllegalArgumentException("n is " + n + ", m is " + m);
		}
		if (1L == m) {
			return 0L;
		}
		long r = 1L, y = safeMod(x, m);
		while (n > 0L) {
			if (1L == (n & 1L)) {
				r = safeMod(r * y, m);
			}
			y = safeMod(y * y, m);
			n >>= 1;
		}
		return r;
	}

	/**
	 * x mod MOD を安全に計算する
	 * 
	 * @param x
	 * @return x mod MOD
	 */
	private static long safeMod(long x) {
		return safeMod(x, MOD);
	}

	/**
	 * x mod m を安全に計算する
	 * 
	 * @param x
	 * @param m
	 * @return x mod m
	 */
	private static long safeMod(long x, long m) {
		x %= m;
		if (x < 0) {
			x += m;
		}
		return x;
	}
}
