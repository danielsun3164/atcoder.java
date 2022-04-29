package abc.abc201_250.abc215;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemG {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] fact = new long[n + 1], invFact = new long[n + 1];
			fact[0] = 1L;
			IntStream.rangeClosed(1, n).forEach(i -> fact[i] = fact[i - 1] * i % MOD);
			invFact[n] = powMod(fact[n], MOD - 2);
			IntStream.range(0, n).map(i -> n - 1 - i).forEach(i -> invFact[i] = invFact[i + 1] * (i + 1) % MOD);
			// 各色の数を保存するマップ（key=色、value=数）
			Map<Integer, Integer> colorCount = new HashMap<>();
			IntStream.range(0, n).forEach(i -> {
				int c = scanner.nextInt();
				colorCount.put(c, colorCount.getOrDefault(c, 0) + 1);
			});
			// 各色の数の数を保存するマップ（key=色の数、value=数）
			Map<Integer, Integer> counts = new HashMap<>();
			colorCount.values().stream().forEach(v -> counts.put(v, counts.getOrDefault(v, 0) + 1));
			// TLE対策のため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			IntStream.rangeClosed(1, n).forEach(k -> {
				long cnk = c(fact, invFact, n, k);
				sb.append(counts.entrySet().stream()
						.mapToLong(
								entry -> (cnk - c(fact, invFact, n - entry.getKey(), k) + MOD) * entry.getValue() % MOD)
						.sum() % MOD * powMod(cnk, MOD - 2) % MOD).append(System.lineSeparator());
			});
			System.out.print(sb.toString());
			System.out.flush();
		}
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
		while (m > 0L) {
			if (1L == (1L & m)) {
				result = result * n % MOD;
			}
			n = n * n % MOD;
			m >>= 1;
		}
		return result;
	}

	/**
	 * n C m mod MODを計算する
	 *
	 * @param fact    階乗の配列
	 * @param invFact 逆階乗の配列
	 * @param n
	 * @param m
	 * @return n C m mod MOD
	 */
	private static long c(long[] fact, long[] invFact, int n, int m) {
		return (n >= m) ? fact[n] * invFact[m] % MOD * invFact[n - m] % MOD : 0L;
	}
}
