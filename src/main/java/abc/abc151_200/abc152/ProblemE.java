package abc.abc151_200.abc152;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemE {

	/** mod対象数字 */
	private static final long MOD = 1_000_000_007L;
	/** 素数計算処理対象数字の最大値 */
	private static final int MAX_VALUE = 1_000;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] primes = calcPrimes(MAX_VALUE);
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			Map<Integer, Integer> map = new HashMap<>();
			IntStream.range(0, n).forEach(i -> calc(a[i], primes, map));
			long lcm = map.entrySet().stream().mapToLong(entry -> powMod(entry.getKey(), entry.getValue())).reduce(1L,
					(r, li) -> r * li % MOD);
			System.out.println(IntStream.range(0, n).mapToLong(i -> lcm * powMod(a[i], MOD - 2) % MOD).sum() % MOD);
		}
	}

	/**
	 * n以下の素数を計算する
	 *
	 * @param n
	 * @return n以下の素数の配列
	 */
	private static int[] calcPrimes(int n) {
		boolean[] isPrime = new boolean[n + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		IntStream.rangeClosed(2, n).forEach(i -> {
			if (isPrime[i]) {
				for (int j = i + i; j <= n; j += i) {
					isPrime[j] = false;
				}
			}
		});
		return IntStream.rangeClosed(0, n).filter(i -> isPrime[i]).toArray();
	}

	/**
	 * nの素因数の階乗数と既存の各素因数の階乗数の最大値を更新する
	 *
	 * @param n
	 * @param primes 素数の一覧
	 * @param map    各素因数の階乗数の最大値
	 */
	private static void calc(int n, int[] primes, Map<Integer, Integer> map) {
		if (n > 1) {
			for (int p : primes) {
				if (0 == (n % p)) {
					int count = 0;
					while (0 == (n % p)) {
						n /= p;
						count++;
					}
					map.put(p, Math.max(map.getOrDefault(p, 0), count));
					if (1 == n) {
						break;
					}
				}
			}
			// n>1の場合、nが素数
			if (n > 1) {
				map.put(n, 1);
			}
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
		while (m > 0) {
			if (1 == (1 & m)) {
				result = result * n % MOD;
			}
			n = n * n % MOD;
			m >>= 1;
		}
		return result;
	}
}
