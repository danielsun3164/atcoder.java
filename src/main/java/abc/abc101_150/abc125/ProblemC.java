package abc.abc101_150.abc125;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] a = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).toArray();
			// l[i]=gcd(a_0,..,a_(i-1))
			long[] l = new long[n + 1];
			l[0] = 0L;
			IntStream.rangeClosed(1, n).forEach(i -> l[i] = gcd(l[i - 1], a[i - 1]));
			// r[i]=gcd(a_i,...a_(n-1))
			long[] r = new long[n + 1];
			r[n] = 0L;
			IntStream.rangeClosed(1, n).map(i -> n - i).forEach(i -> r[i] = gcd(r[i + 1], a[i]));
			System.out.println(IntStream.range(0, n).mapToLong(i -> gcd(l[i], r[i + 1])).max().getAsLong());
		}
	}

	/**
	 * mとnの最大公約数を返す
	 * 
	 * @param m
	 * @param n
	 * @return mとnの最大公約数
	 */
	private static long gcd(long m, long n) {
		if (0L == n) {
			return m;
		}
		return gcd(n, m % n);
	}
}
