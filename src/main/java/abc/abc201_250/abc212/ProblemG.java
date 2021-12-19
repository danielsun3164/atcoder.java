package abc.abc201_250.abc212;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc212/submissions/24711092 にも参考
 */
public class ProblemG {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long p = scanner.nextLong() - 1;
			Set<Long> set = new TreeSet<>();
			for (long c = 1L; c * c <= p; c++) {
				if (0 == (p % c)) {
					set.add(c);
					set.add(p / c);
				}
			}
			int n = set.size();
			long[] a = new long[n], divisors = set.stream().mapToLong(Long::longValue).toArray();
			a[0] = 1L;
			IntStream.range(1, n).forEach(i -> a[i] = (divisors[i]
					- IntStream.range(0, i).filter(j -> 0L == (divisors[i] % divisors[j])).mapToLong(j -> a[j]).sum())
					% MOD);
			System.out.println((IntStream.range(0, n).mapToLong(i -> divisors[i] % MOD * a[i] % MOD).sum() + 1L) % MOD);
		}
	}
}
