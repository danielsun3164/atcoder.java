package abc.abc201_250.abc222;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc222/editorial/2750 の離散対数問題として解く実装
 */
public class ProblemG別回答 {

	/** 10 */
	private static final int TEN = 10;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			while (t-- > 0) {
				int k = scanner.nextInt();
				System.out.println(solve(k));
			}
		}
	}

	/**
	 * mの計算結果を計算する
	 *
	 * @param m
	 * @return mの計算結果
	 */
	private static long solve(int m) {
		if (0 == (1 & m)) {
			m >>= 1;
		}
		m *= 9;
		return ord(TEN, m);
	}

	private static long ord(int a, int m) {
		a %= m;
		if (1 != gcd(a, m)) {
			return -1L;
		}
		int sqrt = (int) Math.sqrt(m) + 1;
		Map<Long, Long> map = new HashMap<>();
		for (long s = a, i = 1; i <= sqrt; i++, s = s * a % m) {
			if (!map.containsKey(s)) {
				map.put(s, i);
			}
		}
		long g = inv(pow(a, sqrt, m), m), x = 1L;
		for (long k = 0; k <= m / sqrt; k++, x = x * g % m) {
			if (map.containsKey(x)) {
				return sqrt * k + map.get(x);
			}
		}
		throw new RuntimeException();
	}

	/**
	 * a ^ c mod b = 1 を満たす最小のcを返す
	 *
	 * @param a
	 * @param b
	 * @return a ^ c mod b = 1 を満たす最小のc
	 */
	private static long inv(int a, int b) {
		if (1 == a) {
			return 1;
		}
		return b + (1 - (b) * inv(b % a, a)) / a;
	}

	/**
	 * aとbの最大公約数を計算する
	 *
	 * @param a
	 * @param b
	 * @return aとbの最大公約数
	 */
	private static int gcd(int a, int b) {
		return (0 == b) ? a : gcd(b, a % b);
	}

	/**
	 * a ^ n % m を計算する
	 *
	 * @param a
	 * @param n
	 * @param m
	 * @return a ^ n % m
	 */
	private static int pow(long a, int n, int m) {
		long answer = 1L;
		a %= m;
		while (n > 0) {
			if (1 == (1 & n)) {
				answer = answer * a % m;
			}
			a = a * a % m;
			n >>= 1;
		}
		return (int) answer;
	}
}
