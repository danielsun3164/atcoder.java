package abc.abc201_250.abc245;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc245/editorial/3636 の実装<br/>
 * https://atcoder.jp/contests/abc245/submissions/30409083 にも参考
 */
public class ProblemEx3 {
	static final long MOD = 998244353L;
	static final int MAX_N = 2_000_000;

	static int[] primes;
	static boolean[] isPrime = new boolean[MAX_N + 1];

	static class Factor {
		long prime;
		long exponent;

		Factor(long prime, long exponent) {
			this.prime = prime;
			this.exponent = exponent;
		}
	}

	static long normalize(long x) {
		return (x % MOD + MOD) % MOD;
	}

	static long powMod(long a, long exp) {
		a = normalize(a);
		long result = 1;

		while (exp > 0) {
			if ((exp & 1L) != 0) {
				result = result * a % MOD;
			}
			a = a * a % MOD;
			exp >>= 1;
		}

		return result;
	}

	static void precal() {
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 2; i <= MAX_N; i++) {
			if (isPrime[i]) {
				list.add(i);

				for (int j = 2 * i; j <= MAX_N; j += i) {
					isPrime[j] = false;
				}
			}
		}

		primes = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			primes[i] = list.get(i);
		}
	}

	static List<Factor> factorize(long n) {
		List<Factor> result = new ArrayList<>();

		for (int p : primes) {
			if ((long) p * p > n) {
				break;
			}

			long count = 0;
			while (n % p == 0) {
				n /= p;
				count++;
			}

			if (count > 0) {
				result.add(new Factor(p, count));
			}
		}

		if (n != 1) {
			int size = result.size();

			if (size >= 1 && result.get(size - 1).prime == n) {
				result.get(size - 1).exponent++;
			} else {
				result.add(new Factor(n, 1));
			}
		}

		return result;
	}

	static long comb(long n, long k) {
		if (k < 0 || n < k) {
			return 0;
		}

		k = Math.min(k, n - k);

		long ans = 1;

		for (long i = 1; i <= k; i++) {
			ans = ans * normalize(n + 1 - i) % MOD;
			ans = ans * powMod(i, MOD - 2) % MOD;
		}

		return ans;
	}

	static long calc(long n, Factor factor, long k) {
		long p = factor.prime;
		long exponent = factor.exponent;

		long q = 1;
		for (long z = 1; z <= exponent; z++) {
			q *= p;
		}
		n %= q;

		long D = (powMod(p, exponent) - powMod(p, exponent - 1) + MOD) % MOD;

		if (n == 0) {
			long[] a = new long[(int) exponent + 1];

			for (int i = 0; i <= exponent; i++) {
				a[i] = powMod(p, exponent - i);
			}

			for (int i = 0; i < exponent; i++) {
				a[i] = (a[i] - a[i + 1] + MOD) % MOD;
			}

			long[] b = new long[(int) exponent];

			for (int i = 0; i < exponent; i++) {
				b[i] = powMod(D, k - 1) * comb(i + k - 1, k - 1) % MOD;
			}

			long ans = powMod(powMod(p, exponent), k);

			for (int i = 0; i < exponent; i++) {
				ans = (ans - a[i] * b[i] % MOD + MOD) % MOD;
			}

			return ans;
		} else {
			long count = 0;

			while (n % p == 0) {
				count++;
				n /= p;
			}

			if (count >= exponent) {
				throw new IllegalStateException("count must be smaller than exponent");
			}

			return powMod(D, k - 1) * comb(count + k - 1, k - 1) % MOD;
		}
	}

	public static void main(String[] args) throws Exception {
		FastScanner fs = new FastScanner(System.in);

		precal();

		long k = fs.nextLong();
		long n = fs.nextLong();
		long m = fs.nextLong();

		List<Factor> factors = factorize(m);

		long ans = 1;

		for (Factor factor : factors) {
			ans = ans * calc(n, factor, k) % MOD;
		}

		System.out.println(ans);
	}

	static class FastScanner {
		private final InputStream in;
		private final byte[] buffer = new byte[1 << 16];
		private int ptr = 0;
		private int len = 0;

		FastScanner(InputStream in) {
			this.in = in;
		}

		private int read() throws IOException {
			if (ptr >= len) {
				len = in.read(buffer);
				ptr = 0;

				if (len <= 0) {
					return -1;
				}
			}

			return buffer[ptr++];
		}

		long nextLong() throws IOException {
			int c;

			do {
				c = read();
			} while (c <= ' ' && c != -1);

			long sign = 1;

			if (c == '-') {
				sign = -1;
				c = read();
			}

			long value = 0;

			while (c > ' ') {
				value = value * 10 + c - '0';
				c = read();
			}

			return value * sign;
		}
	}
}
