package abc.abc201_250.abc212;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * アダマール変換の実装<br/>
 * https://atcoder.jp/contests/abc212/submissions/24641867 にも参考
 */
public class ProblemH {

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
			walshHadamardTransform(c);
			IntStream.range(0, N).forEach(i -> c[i] = func(c[i], n));
			walshHadamardTransform(c);
			System.out.println(IntStream.range(1, N).mapToLong(i -> c[i]).sum() % MOD * modPow(N, MOD - 2) % MOD);
		}
	}

	/**
	 * アダマール変換を実施
	 *
	 * @param c 変換対象配列
	 */
	private static void walshHadamardTransform(long[] c) {
		for (int i = 1; i < N; i <<= 1) {
			for (int j = 0; j < N; j++) {
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

	/**
	 * x+x^2+...+x^n mod MODを計算する
	 *
	 * @param x
	 * @param n
	 * @return x+x^2+...+x^n mod MOD
	 */
	private static long func(long x, long n) {
		x %= MOD;
		if (0L == x) {
			return 0L;
		}
		if (1L == x) {
			return n;
		}
		return (modPow(x, n) - 1L + MOD) % MOD * x % MOD * modPow(x - 1, MOD - 2) % MOD;
	}
}
