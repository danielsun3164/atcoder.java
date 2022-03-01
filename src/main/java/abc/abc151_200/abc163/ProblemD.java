package abc.abc151_200.abc163;

import java.util.Scanner;
import java.util.stream.LongStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemD {

	/** mod対象数字 */
	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			long answer = LongStream.rangeClosed(k, n + 1).reduce(0L, (s, i) -> (s + calc(n + 1, i)) % MOD);
			System.out.println(answer);
		}
	}

	/**
	 * n個数字からk個を選んだ和の数を計算する
	 *
	 * @param n
	 * @param k
	 * @return n個数字からk個を選んだ和の数
	 */
	private static long calc(long n, long k) {
		// 一番大きいk個の数を選んだときの和 − 一番小さいk個の数を選んだときの和 + 1
		return (n + n - k + 1) * k / 2L - k * (k + 1) / 2L + 1;
	}
}
