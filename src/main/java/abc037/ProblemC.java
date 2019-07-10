package abc037;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			int[] a = new int[n];
			IntStream.range(0, n).forEach(i -> a[i] = scanner.nextInt());
			System.out.println(IntStream.range(0, n).mapToLong(i -> a[i] * getCount(n, k, i)).sum());
		}
	}

	/**
	 * @param n 数列の長さ
	 * @param k 選ばれる連結部分の長さ
	 * @param i 数列の何番目か
	 * @return 該当の数字を足す回数
	 */
	private static long getCount(int n, int k, int i) {
		if (i < k - 1) {
			return Math.min(i + 1, n - k + 1);
		} else if (i > n - k) {
			return Math.min(n - i, n - k + 1);
		}
		return Math.min(k, n - k + 1);
	}
}
