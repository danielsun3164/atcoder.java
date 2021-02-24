package abc.abc101_150.abc137;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int p = scanner.nextInt();
			int[] a = IntStream.range(0, p).map(i -> scanner.nextInt()).toArray();
			int[] fact = new int[p], revFact = new int[p], b = new int[p];
			fact[0] = 1;
			IntStream.range(1, p).forEach(i -> fact[i] = fact[i - 1] * i % p);
			revFact[p - 1] = powMod(fact[p - 1], p - 2, p);
			IntStream.range(1, p).map(i -> p - 1 - i).forEach(i -> revFact[i] = revFact[i + 1] * (i + 1) % p);
			Arrays.fill(b, 0);
			IntStream.range(0, p).filter(i -> 1 == a[i]).forEach(i -> {
				b[0]++;
				IntStream.range(0, p).forEach(
						// b[j]は 1-(x-i)^{p-1}のx^jの項の係数の合計
						j -> b[j] = (b[j] - powMod(-i, p - 1 - j, p) * c(p - 1, j, p, fact, revFact) % p + p) % p);
			});
			System.out.println(Arrays.stream(b).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
		}
	}

	/**
	 * n^m mod p を計算する
	 * 
	 * @param n
	 * @param m
	 * @param p
	 * @return n^m mod p
	 */
	private static int powMod(int n, int m, final int p) {
		int result = 1;
		while (m > 0) {
			if (1 == (1 & m)) {
				result = result * n % p;
			}
			n = n * n % p;
			m >>= 1;
		}
		return result;
	}

	/**
	 * n_C_m mod pを計算する
	 * 
	 * @param n
	 * @param m
	 * @param p
	 * @param fact    階乗 mod pの配列
	 * @param revFact 階乗^{-1} mod pの配列
	 * @return n_C_m mod p
	 */
	private static int c(final int n, final int m, final int p, final int[] fact, final int[] revFact) {
		return fact[n] * revFact[n - m] % p * revFact[m] % p;
	}
}
