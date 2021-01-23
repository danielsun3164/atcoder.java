package abc.abc151_200.abc189;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 * 
 * 解法2 二分探索の実装
 */
public class ProblemF別回答 {

	/** 二分探索の最大値 */
	private static final double INF = 8E10d;
	/** 誤差 */ // 1E-4dの場合ではWAになる
	private static final double TOLERANCE = 1E-5d;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt(), k = scanner.nextInt();
			Set<Integer> a = IntStream.range(0, k).map(i -> scanner.nextInt()).boxed().collect(Collectors.toSet());
			double[] h = new double[n + m];
			Arrays.fill(h, 0.0d);
			// leftは回答
			double left = 0.0d, right = INF;
			while (right - left >= TOLERANCE) {
				// sumはh[i+1]+...+h[i+m]
				double sum = 0.0d, med = (left + right) / 2.0;
				for (int i = n - 1; i >= 0; i--) {
					if (a.contains(i)) {
						h[i] = med;
					} else {
						h[i] = sum / m + 1.0d;
					}
					sum += h[i] - h[i + m];
				}
				if (h[0] > med) {
					left = med;
				} else {
					right = med;
				}
			}
			System.out.println(((INF - left) < TOLERANCE) ? String.valueOf(-1) : String.valueOf(right));
		}
	}
}
