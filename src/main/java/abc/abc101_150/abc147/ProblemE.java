package abc.abc101_150.abc147;

import java.util.BitSet;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt();
			int[][] a = new int[h][w], b = new int[h][w], c = new int[h][w];
			IntStream.range(0, h).forEach(i -> IntStream.range(0, w).forEach(j -> a[i][j] = scanner.nextInt()));
			int n = (h + w) * IntStream.range(0, h).map(i -> IntStream.range(0, w).map(j -> {
				b[i][j] = scanner.nextInt();
				return c[i][j] = Math.abs(a[i][j] - b[i][j]);
			}).max().getAsInt()).max().getAsInt();
			BitSet[][] dp = new BitSet[h][w];
			IntStream.range(0, h).forEach(i -> IntStream.range(0, w).forEach(j -> dp[i][j] = new BitSet(n + 1)));
			IntStream.range(0, h).forEach(i -> IntStream.range(0, w).forEach(j -> {
				if ((0 == i) && (0 == j)) {
					dp[i][j].set(c[i][j], true);
				} else {
					IntStream.rangeClosed(0, n).forEach(k -> {
						if (((i > 0) && dp[i - 1][j].get(k)) || ((j > 0) && dp[i][j - 1].get(k))) {
							dp[i][j].set(k + c[i][j], true);
							dp[i][j].set(Math.abs(k - c[i][j]), true);
						}
					});
				}
			}));
			System.out.println(IntStream.rangeClosed(0, n).filter(i -> dp[h - 1][w - 1].get(i)).findFirst().getAsInt());
		}
	}
}
