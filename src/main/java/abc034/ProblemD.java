package abc034;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemD {

	private static final double EPS = 1.0E-10;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			long[] w = new long[n];
			int[] p = new int[n];
			IntStream.range(0, n).forEach(i -> {
				w[i] = scanner.nextLong();
				p[i] = scanner.nextInt();
			});
			System.out.println(getResult(0.0d, 100.0d, n, k, w, p));
		}
	}

	/**
	 * @param start 開始濃度（必ず達成できる）
	 * @param end   終了濃度（達成できない）
	 * @param n     食塩水の数
	 * @param k     選ぶ食塩水の数
	 * @param w     重さの配列
	 * @param p     濃度の配列
	 * @return 達成できる最大濃度
	 */
	private static double getResult(double start, double end, final int n, final int k, final long[] w, final int[] p) {
		if ((end - start) < EPS) {
			return start;
		}
		double middle = (start + end) / 2.0d;
		if (IntStream.range(0, n).mapToDouble(i -> w[i] * (p[i] - middle)).sorted().skip(n - k).sum() >= 0) {
			return getResult(middle, end, n, k, w, p);
		} else {
			return getResult(start, middle, n, k, w, p);
		}
	}
}
