package abc.abc151_200.abc189;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * 解法1 1次式を持つDPの実装 （テストケースを通すためBigDecimalで実装）
 */
public class ProblemF {

	/** 割り算のときの精度 */
	private static final int DIGIT = 20;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt(), k = scanner.nextInt();
			BitSet bitSet = new BitSet(n);
			IntStream.range(0, k).forEach(i -> bitSet.set(scanner.nextInt(), true));
			// g[i][0]はXの係数、g[i][1]は数字そのまま
			BigDecimal[][] g = new BigDecimal[n + m][2];
			IntStream.range(0, n + m).forEach(i -> Arrays.fill(g[i], BigDecimal.ZERO));
			// sum[k]はg[i+1][k]+...+h[i+m][k]
			BigDecimal[] sum = new BigDecimal[] { BigDecimal.ZERO, BigDecimal.ZERO };
			BigDecimal bm = BigDecimal.valueOf(m);
			for (int i = n - 1; i >= 0; i--) {
				if (bitSet.get(i)) {
					g[i][0] = BigDecimal.ONE;
					g[i][1] = BigDecimal.ZERO;
				} else {
					g[i][0] = sum[0].divide(bm, DIGIT, RoundingMode.HALF_UP);
					g[i][1] = sum[1].divide(bm, DIGIT, RoundingMode.HALF_UP).add(BigDecimal.ONE);
				}
				sum[0] = sum[0].add(g[i][0].subtract(g[i + m][0]));
				sum[1] = sum[1].add(g[i][1].subtract(g[i + m][1]));
			}
			// 判定条件は https://atcoder.jp/contests/abc189/submissions/19650957 に参考
			System.out
					.println((g[0][0].subtract(BigDecimal.ONE).abs().compareTo(new BigDecimal("1E-" + (DIGIT + 1))) < 0)
							? BigDecimal.valueOf(-1)
							: g[0][1].divide(BigDecimal.ONE.subtract(g[0][0]), DIGIT, RoundingMode.HALF_UP));
		}
	}
}
