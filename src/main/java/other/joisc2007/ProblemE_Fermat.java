package other.joisc2007;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * https://atcoder.jp/contests/joisc2007/submissions/4252113 を参考に作成
 */
public class ProblemE_Fermat {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int p = scanner.nextInt(), n = scanner.nextInt();
			int[] count = new int[p];
			IntStream.range(0, p).forEach(i -> count[powMod(i, n, p)]++);
			System.out.println(IntStream.range(0, p)
					.map(i -> count[i] * count[i] * count[(i + i) % p]
							+ IntStream.range(i + 1, p).map(j -> 2 * count[i] * count[j] * count[(i + j) % p]).sum())
					.sum());
		}
	}

	/**
	 * x^n mod m を計算する
	 * 
	 * @param x
	 * @param n
	 * @param m
	 * @return x^n mod m
	 */
	private static int powMod(int x, int n, int m) {
		if (!((0 <= n) || (1 <= m))) {
			throw new IllegalArgumentException("n is " + n + ", m is " + m);
		}
		if (1 == m) {
			return 0;
		}
		int r = 1, y = safeMod(x, m);
		while (n > 0) {
			if (1 == (n & 1)) {
				r = safeMod(r * y, m);
			}
			y = safeMod(y * y, m);
			n >>= 1;
		}
		return r;
	}

	/**
	 * x mod m を安全に計算する
	 * 
	 * @param x
	 * @param m
	 * @return x mod m
	 */
	private static int safeMod(int x, int m) {
		x %= m;
		if (x < 0) {
			x += m;
		}
		return x;
	}
}
