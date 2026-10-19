package abc.abc201_250.abc245;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc245/editorial/3636 の実装<br/>
 * https://atcoder.jp/contests/abc245/submissions/30409083 にも参考
 */
public class ProblemEx {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;
	/** 素数の最大値 */
	private static final int N = 2_000_000;

	private static boolean[] isPrime;
	private static int[] primes;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			init();
			long k = scanner.nextLong(), n = scanner.nextLong(), m = scanner.nextLong();
			List<Factor> factors = factorize(m);
			long answer = 1;
			for (Factor factor : factors) {
				answer = answer * calc(n, factor, k) % MOD;
			}
			System.out.println(answer);
		}
	}

	/**
	 * エラトステネスの篩を用いて、N 以下の素数を列挙する。素数判定配列 isPrime と、素数を格納する配列 primes を初期化する。
	 */
	private static void init() {
		isPrime = new boolean[N + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		List<Integer> list = new ArrayList<>();
		IntStream.rangeClosed(2, N).filter(i -> isPrime[i]).forEach(i -> {
			list.add(i);
			IntStream.iterate(2 * i, j -> j <= N, j -> j + i).forEach(j -> isPrime[j] = false);
		});
		primes = list.stream().mapToInt(Integer::intValue).toArray();
	}

	/**
	 * 整数を法 MOD に関する剰余の代表元に正規化する。 負数の場合も、結果が 0 以上 MOD 未満になるように変換する。
	 *
	 * @param x 正規化する整数
	 * @return 0 以上 MOD 未満の剰余
	 */
	private static long normalize(long x) {
		if (x < 0) {
			return (x % MOD + MOD) % MOD;
		}
		return (x >= MOD) ? x % MOD : x;
	}

	/**
	 * 与えられた正整数を素因数分解する。 init() で生成した素数配列 primes を使用する。
	 *
	 * @param n 素因数分解する正整数
	 * @return 素因数とその指数を格納したリスト
	 */
	static List<Factor> factorize(long n) {
		List<Factor> result = new ArrayList<>();
		for (int p : primes) {
			if ((long) p * p > n) {
				break;
			}
			int count = 0;
			while (0 == n % p) {
				n /= p;
				count++;
			}
			if (count > 0) {
				result.add(new Factor(p, count));
			}
		}
		if (n != 1) {
			result.add(new Factor(n, 1));
		}
		return result;
	}

	/**
	 * 二項係数 C(n, k) を法 MOD で計算する。 階乗の逆元を逐次求めるのではなく、各分母の逆元を用いて計算する。
	 *
	 * @param n 二項係数の上側の整数
	 * @param k 二項係数の下側の整数
	 * @return C(n, k) mod MOD。不適切な範囲の場合は 0
	 */
	private static long comb(long n, long k) {
		if (k < 0 || n < k) {
			return 0L;
		}
		k = Math.min(k, n - k);
		long result = 1L;
		for (long i = 1L; i <= k; i++) {
			result = result * normalize(n + 1 - i) % MOD;
			result = result * powMod(i, MOD - 2) % MOD;
		}
		return result;
	}

	/**
	 * 素因数 p^exponent に対応する計算結果を求める。 n を p^exponent で割った余りに応じて場合分けし、 二項係数と MOD 上の累乗を用いて結果を計算する。
	 *
	 * @param n      計算対象の整数
	 * @param factor 素因数とその指数
	 * @param k      計算に用いる正整数
	 * @return 素因数 factor に対応する計算結果（mod MOD）
	 */
	private static long calc(long n, Factor factor, long k) {
		long p = factor.prime;
		int exponent = factor.exponent;
		long q = LongStream.range(0, exponent).reduce(1, (s, _) -> s * p);
		n %= q;
		long d = (powMod(p, exponent) - powMod(p, exponent - 1) + MOD) % MOD;
		if (n == 0) {
			long[] a = IntStream.rangeClosed(0, exponent).mapToLong(i -> powMod(p, exponent - i)).toArray();
			IntStream.range(0, exponent).forEach(i -> a[i] = (a[i] - a[i + 1] + MOD) % MOD);
			long[] b = IntStream.range(0, exponent).mapToLong(i -> powMod(d, k - 1) * comb(i + k - 1, k - 1) % MOD)
					.toArray();
			return LongStream.range(0, exponent).reduce(powMod(powMod(p, exponent), k),
					(s, i) -> (s - a[(int) i] * b[(int) i] % MOD + MOD) % MOD);
		} else {
			long count = 0;
			while (n % p == 0) {
				count++;
				n /= p;
			}
			if (count >= exponent) {
				throw new IllegalStateException("count must be smaller than exponent");
			}
			return powMod(d, k - 1) * comb(count + k - 1, k - 1) % MOD;
		}
	}

	/**
	 * x^a mod MODを計算する
	 *
	 * @param x
	 * @param a
	 * @return x^a mod MOD
	 */
	private static long powMod(long x, long a) {
		long result = 1L;
		x = normalize(x);
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
	 * p^q を表すクラス
	 */
	private static class Factor {
		long prime;
		int exponent;

		Factor(long prime, int exponent) {
			this.prime = prime;
			this.exponent = exponent;
		}
	}
}
