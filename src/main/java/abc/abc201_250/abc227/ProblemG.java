package abc.abc201_250.abc227;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc227/editorial/2909 の実装<br/>
 * https://atcoder.jp/contests/abc227/submissions/27209472 にも参考
 */
public class ProblemG {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			int k = scanner.nextInt(), m = Math.max((int) Math.sqrt(n), k);
			boolean[] isPrime = calcPrimes(m);
			long[] deno = IntStream.rangeClosed(0, k).asLongStream().toArray();
			long offset = n - k + 1;
			long[] nume = LongStream.rangeClosed(offset, n).toArray();
			long answer = 1L;
			for (int p = 2; p <= m; p++) {
				if (isPrime[p]) {
					int power = 0;
					for (int i = p; i <= k; i += p) {
						while (0L == deno[i] % p) {
							power--;
							deno[i] /= p;
						}
					}
					for (long i = (offset + p - 1) / p * p; i <= n; i += p) {
						int index = (int) (i - offset);
						while (0 == nume[index] % p) {
							power++;
							nume[index] /= p;
						}
					}
					answer = answer * (power + 1) % MOD;
				}
			}
			for (long i = offset; i <= n; i++) {
				int index = (int) (i - offset);
				if (1L != nume[index]) {
					answer = answer * 2L % MOD;
				}
			}
			System.out.println(answer);
		}
	}

	/**
	 * nまでの素数の一覧を取得する
	 *
	 * @param n
	 * @return nまでの素数の一覧
	 */
	private static boolean[] calcPrimes(int n) {
		boolean[] prime = new boolean[n + 1];
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		for (int p = 2; p * p <= n; p++) {
			if (prime[p]) {
				for (int j = p + p; j <= n; j += p) {
					prime[j] = false;
				}
			}
		}
		return prime;
	}
}
