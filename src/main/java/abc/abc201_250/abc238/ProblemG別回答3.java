package abc.abc201_250.abc238;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc238/editorial/3379 の実装<br/>
 * https://atcoder.jp/contests/abc238/submissions/29106432 にも参考
 */
public class ProblemG別回答3 {

	/** 10^6 */
	private static final int MAX = 1_000_000;
	/** 3 */
	private static final int N = 3;
	/** mod対象数字 */
	private static final long MOD = 1_000_000_033L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), q = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray(), count = new int[MAX + 1];
			Arrays.fill(count, 0);
			long[] c = new long[n + 1];
			Arrays.fill(c, 1L);
			SOE soe = new SOE(MAX);
			long hash = 1L;
			for (int i = 0; i < n; i++) {
				for (int j : soe.fact(a[i])) {
					hash = (hash * j) % MOD;
					count[j]++;
					if (N == count[j]) {
						hash = hash * powMod(j, N * (MOD - 2)) % MOD;
						count[j] = 0;
					}
				}
				c[i + 1] = hash;
			}
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, q)
					.forEach(i -> sb.append((c[scanner.nextInt() - 1] == c[scanner.nextInt()]) ? "Yes" : "No")
							.append(System.lineSeparator()));
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
		while (m > 0) {
			if (1 == (1 & m)) {
				result = (result * n) % MOD;
			}
			n = (n * n) % MOD;
			m >>= 1;
		}
		return result;
	}

	private static class SOE {
		int[] sieve;

		SOE(int n) {
			sieve = new int[n + 1];
			Arrays.fill(sieve, -1);
			IntStream.rangeClosed(2, n).filter(i -> -1 == sieve[i]).forEach(i -> {
				sieve[i] = i;
				IntStream.iterate(i + i, j -> j <= n, j -> j + i).forEach(j -> sieve[j] = i);
			});
		}

		/**
		 * 数字nの因数分解を行う
		 *
		 * @param n
		 * @return 因数分解の結果配列
		 */
		int[] fact(int n) {
			List<Integer> list = new ArrayList<>();
			while (1 != n) {
				int k = sieve[n];
				list.add(k);
				n /= k;
			}
			return list.stream().mapToInt(Integer::intValue).toArray();
		}

		@SuppressWarnings("unused")
		int[] div(int n) {
			List<Integer> list = new ArrayList<>();
			list.add(1);
			while (1 != n) {
				int p = sieve[n], count = 1;
				n /= p;
				while (p == sieve[n]) {
					count++;
					n /= p;
				}
				List<Integer> list2 = new ArrayList<>(list);
				for (int i : list2) {
					int p2 = 1;
					for (int j = 1; j <= count; j++) {
						list.add(i * (p2 *= p));
					}
				}
			}
			return list.stream().mapToInt(Integer::intValue).toArray();
		}
	}
}
