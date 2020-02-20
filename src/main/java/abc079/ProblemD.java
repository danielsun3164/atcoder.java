package abc079;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	/** 魔力配列のサイズ */
	private static final int N = 10;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt();
			int w = scanner.nextInt();
			int[][] c = new int[N][N];
			IntStream.range(0, N).forEach(i -> IntStream.range(0, N).forEach(j -> c[i][j] = scanner.nextInt()));
			int[][] a = new int[h][w];
			IntStream.range(0, h).forEach(i -> IntStream.range(0, w).forEach(j -> a[i][j] = scanner.nextInt()));
			// 魔力の最短ルートの再計算
			warshallFloyd(c, N);
			System.out.println(IntStream.range(0, h)
					.map(i -> IntStream.range(0, w).filter(j -> a[i][j] != -1).map(j -> c[a[i][j]][1]).sum()).sum());
		}
	}

	/**
	 * ノード関の移動コストを計算する
	 * 
	 * @param costs ノード関の移動コストの配列
	 * @param n     ノードの総数
	 */
	private static void warshallFloyd(int[][] costs, int n) {
		IntStream.range(0, n).forEach(k -> IntStream.range(0, n).forEach(j -> IntStream.range(0, n)
				.forEach(i -> costs[i][j] = Math.min(costs[i][j], costs[i][k] + costs[k][j]))));
	}
}
