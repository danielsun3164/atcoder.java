package abc.abc201_250.abc212;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * DPの高速化の実装<br/>
 * https://atcoder.jp/contests/abc212/submissions/24641936 にも参考
 */
public class ProblemH別回答 {

	/** kとAiの最大値 */
	private static final int N = 1 << 16;
	/** mod対象数字 */
	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			long[] c = new long[N];
			Arrays.fill(c, 0L);
			IntStream.range(0, k).forEach(i -> c[scanner.nextInt()] = 1L);
			long[] s = calc(n, c)[0];
			System.out.println(IntStream.range(1, N).mapToLong(i -> s[i]).sum() % MOD);
		}
	}

	private static long[][] calc(int n, long[] x) {
		if (1 == n) {
			return new long[][] { x, x };
		}
		long[][] r = calc(n >> 1, x);
		long[] s = r[0], f = r[1];
		s = add(multiply(s, f), s);
		f = multiply(f, f);
		if (1 == (n & 1)) {
			s = add(multiply(s, x), x);
			f = multiply(f, x);
		}
		return new long[][] { s, f };
	}

	/**
	 * 配列の足し算を行う
	 *
	 * @param a
	 * @param b
	 * @return 足し算の結果
	 */
	private static long[] add(long[] a, long[] b) {
		return IntStream.range(0, a.length).mapToLong(i -> (a[i] + b[i]) % MOD).toArray();
	}

	/**
	 * 配列の掛け算を行う
	 *
	 * @param a
	 * @param b
	 * @return 掛け算の結果
	 */
	private static long[] multiply(long[] a, long[] b) {
		int n = a.length;
		long[] a2 = new long[n], b2 = new long[n];
		System.arraycopy(a, 0, a2, 0, n);
		System.arraycopy(b, 0, b2, 0, n);
		walshHadamardTransform(a2);
		walshHadamardTransform(b2);
		IntStream.range(0, n).forEach(i -> a2[i] = a2[i] * b2[i] % MOD);
		walshHadamardTransform(a2);
		long inv = modPow(n, MOD - 2);
		IntStream.range(0, n).forEach(i -> a2[i] = a2[i] * inv % MOD);
		return a2;
	}

	/**
	 * アダマール変換を実施
	 *
	 * @param c 変換対象配列
	 */
	private static void walshHadamardTransform(long[] c) {
		int n = c.length;
		for (int i = 1; i < n; i <<= 1) {
			for (int j = 0; j < n; j++) {
				if (0 == (i & j)) {
					long x = c[j], y = c[j | i];
					c[j] = (x + y) % MOD;
					c[j | i] = (x - y + MOD) % MOD;
				}
			}
		}
	}

	/**
	 * x^a mod MODを計算する
	 *
	 * @param x
	 * @param a
	 * @return x^a mod MOD
	 */
	private static long modPow(long x, long a) {
		long result = 1L;
		x %= MOD;
		while (a > 0) {
			if (1 == (1 & a)) {
				result = result * x % MOD;
			}
			x = x * x % MOD;
			a >>= 1;
		}
		return result;
	}
}
