package abc.abc151_200.abc189;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 * 
 * 解法1 1次式を持つDPの実装
 */
public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt(), k = scanner.nextInt();
			Set<Integer> a = IntStream.range(0, k).map(i -> scanner.nextInt()).boxed().collect(Collectors.toSet());
			// g[i][0]はXの係数、g[i][1]は数字そのまま
			double[][] g = new double[n + m][2];
			IntStream.range(0, n + m).forEach(i -> Arrays.fill(g[i], 0.0d));
			// sum[k]はg[i+1][k]+...+h[i+m][k]
			double[] sum = new double[] { 0.0d, 0.0d };
			for (int i = n - 1; i >= 0; i--) {
				if (a.contains(i)) {
					g[i][0] = 1.0d;
					g[i][1] = 0.0d;
				} else {
					g[i][0] = sum[0] / m;
					g[i][1] = sum[1] / m + 1.0d;
				}
				sum[0] += g[i][0] - g[i + m][0];
				sum[1] += g[i][1] - g[i + m][1];
			}
			// 判定条件は https://atcoder.jp/contests/abc189/submissions/19650957 に参考
			System.out.println((Math.abs(g[0][0] - 1.0d) < 0.00000000001d) ? String.valueOf(-1)
					: String.valueOf(g[0][1] / (1.0d - g[0][0])));
		}
	}
}
