package abc.abc151_200.abc168;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * https://atcoder.jp/contests/abc168/submissions/14643189 を参考に作成
 */
public class ProblemE {

	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int zero = 0;
			Tupple zeroTupple = new Tupple();
			Map<String, Tupple> map = new HashMap<>();
			map.put("0", zeroTupple);
			// p2[i] = 2^i mod MOD の配列
			long[] p2 = new long[n + 1];
			p2[0] = 1;
			IntStream.rangeClosed(1, n).forEach(i -> p2[i] = p2[i - 1] * 2 % MOD);
			for (int i = 0; i < n; i++) {
				long a = scanner.nextLong(), b = scanner.nextLong();
				if ((0 == a) && (0 == b)) {
					zero++;
				} else if (0 == a) {
					zeroTupple.a++;
				} else if (0 == b) {
					zeroTupple.b++;
				} else {
					if (b < 0) {
						a = -a;
						b = -b;
					}
					long gcd = gcd(Math.abs(a), Math.abs(b));
					a /= gcd;
					b /= gcd;
					String key = (a > 0) ? a + "/" + b : b + "/" + (-a);
					Tupple tupple = map.get(key);
					if (null == tupple) {
						tupple = new Tupple();
						map.put(key, tupple);
					}
					if (a > 0) {
						tupple.a++;
					} else {
						tupple.b++;
					}
				}
			}
			long answer = 1L;
			for (Tupple tupple : map.values()) {
				answer = answer * (p2[tupple.a] + p2[tupple.b] - 1) % MOD;
			}
			answer = (answer + zero + MOD - 1) % MOD;
			System.out.println(answer);
		}
	}

	/**
	 * mとnの最大公約数を返す
	 * 
	 * @param m
	 * @param n
	 * @return mとnの最大公約数
	 */
	private static long gcd(long m, long n) {
		if (0 == n) {
			return m;
		}
		return gcd(n, m % n);
	}

	/**
	 * aとbを格納するクラス
	 */
	private static class Tupple {
		int a = 0;
		int b = 0;
	}
}
