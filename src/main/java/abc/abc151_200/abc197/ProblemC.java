package abc.abc151_200.abc197;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] a = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).toArray();
			System.out.println(IntStream.range(0, 1 << (n - 1)).mapToLong(i -> getResult(n, a, i)).min().getAsLong());
		}
	}

	/**
	 * bitで表す分割方法で分割した場合の結果を計算する
	 *
	 * @param n   数列の長さ
	 * @param a   数列
	 * @param bit 数列を分割するビット表現
	 * @return 計算結果
	 */
	private static long getResult(int n, long[] a, int bit) {
		long answer = 0L, now = 0L;
		for (int i = 0; i < n; i++) {
			now |= a[i];
			if ((bit & (1 << i)) > 0) {
				answer ^= now;
				now = 0L;
			}
		}
		return answer ^ now;
	}
}
