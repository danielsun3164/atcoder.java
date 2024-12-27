package abc.abc201_250.abc236;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc236/editorial/3910 の実装<br/>
 * https://atcoder.jp/contests/abc236/submissions/31394125 にも参考
 */
public class ProblemEx別回答 {

	/** mod対象数字 */
	private static final int MOD = 998_244_353;
	/** 階乗と逆階乗の配列 */
	private static long[] fact, inv;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			init(n);
			long m = scanner.nextLong();
			long[] d = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).toArray(), lcm = new long[1 << n];
			Arrays.fill(lcm, 1L);
			IntStream.range(0, n).forEach(
					i -> IntStream.range(0, 1 << n).forEach(bit -> lcm[bit | 1 << i] = lcm(lcm[bit], d[i], m)));
			// 要素数 n の集合に、数え上げの (-1)^{n-1}(n-1)! 倍をつける
			long[][] f = new long[1 << n][n + 1];
			Arrays.fill(f[0], 0L);
			IntStream.range(1, 1 << n).forEach(bit -> {
				Arrays.fill(f[bit], 0L);
				int count = Integer.bitCount(bit);
				long x = (m / lcm[bit]) % MOD * fact[count - 1] % MOD;
				f[bit][count] = (0 == (1 & count)) ? (MOD - x) % MOD : x;
			});

			// zeta
			IntStream.range(0, n).forEach(i -> IntStream.range(0, 1 << n).forEach(bit -> {
				int t = bit | (1 << i);
				if (bit != t) {
					IntStream.rangeClosed(1, n).forEach(j -> f[t][j] = (f[t][j] + f[bit][j]) % MOD);
				}
			}));

			// exp
			IntStream.range(0, 1 << n).forEach(bit -> f[bit] = fpsExp(f[bit]));

			// 要素数 N のところだけ包除する
			System.out.println(IntStream.range(0, 1 << n)
					.mapToLong(bit -> (0 == (1 & (n - Integer.bitCount(bit)))) ? f[bit][n] : MOD - f[bit][n]).sum()
					% MOD);
		}
	}

	/**
	 * 初期化を行う
	 *
	 * @param n
	 */
	private static void init(int n) {
		fact = new long[n + 1];
		fact[0] = 1L;
		IntStream.rangeClosed(1, n).forEach(i -> fact[i] = fact[i - 1] * i % MOD);
		inv = new long[n + 1];
		IntStream.rangeClosed(1, n).forEach(i -> inv[i] = powMod(i, MOD - 2));
	}

	/**
	 * n^m mod MODを計算する
	 *
	 * @param n
	 * @param m
	 * @return n^m mod MOD
	 */
	private static long powMod(long n, long m) {
		long result = 1L;
		while (m > 0) {
			if (1 == (1 & m)) {
				result = (result * n) % MOD;
			}
			n = (n * n) % MOD;
			m >>= 1;
		}
		return result;
	}

	/**
	 * aとbの最小公倍数を計算する。ただし、結果がmaxを超える場合、max+1を返す
	 *
	 * @param a
	 * @param b
	 * @param max 結果の最大値
	 * @return aとbの最小公倍数。ただし、結果がmaxを超える場合はmax+1
	 */
	private static long lcm(long a, long b, long max) {
		if ((a > max) || (b > max)) {
			return max + 1;
		}
		a /= gcd(a, b);
		return (a <= max / b) ? a * b : max + 1;
	}

	/**
	 * aとbの最大公約数を計算する
	 *
	 * @param a
	 * @param b
	 * @return aとbの最大公約数
	 */
	private static long gcd(long a, long b) {
		return (0L == b) ? a : gcd(b, a % b);
	}

	private static long[] fpsExp(long[] f) {
		int n = f.length;
		IntStream.range(0, n - 1).forEach(i -> f[i] = f[i + 1] * (i + 1) % MOD);

		long[] g = new long[n];
		Arrays.fill(g, 0L);
		g[0] = 1L;
		IntStream.range(1, n).forEach(
				i -> g[i] = IntStream.range(0, i).mapToLong(j -> f[j] * g[i - 1 - j] % MOD).sum() % MOD * inv[i] % MOD);
		return g;
	}
}
