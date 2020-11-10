package other.past201912open;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * LCAでの実装
 * 
 * https://atcoder.jp/contests/past201912-open/submissions/14629223 を参考に作成
 */
public class ProblemK別回答 {

	/** 最大階層数 */
	private static final int K = 20;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[][] parents = new int[K][n];
			@SuppressWarnings("unchecked")
			List<Integer>[] subordinates = new List[n];
			IntStream.range(0, n).forEach(i -> subordinates[i] = new ArrayList<>());
			int root = 0;
			for (int i = 0; i < n; i++) {
				parents[0][i] = scanner.nextInt() - 1;
				if (parents[0][i] != -2) {
					subordinates[parents[0][i]].add(i);
				} else {
					parents[0][i] = i;
					root = i;
				}
			}
			int[] depths = new int[n];
			setDepths(subordinates, depths, root, 0);
			// 速度を上げるため、Streamをやめる
			for (int i = 1; i < K; i++) {
				for (int j = 0; j < n; j++) {
					parents[i][j] = parents[i - 1][parents[i - 1][j]];
				}
			}
			int q = scanner.nextInt();
			for (int i = 0; i < q; i++) {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				if (depths[a] <= depths[b]) {
					System.out.println("No");
				} else {
					int u = a;
					for (int j = 0; j < K; j++) {
						if (0 != ((depths[a] - depths[b]) & (1 << j))) {
							u = parents[j][u];
						}
					}
					System.out.println((u == b) ? "Yes" : "No");
				}
			}
		}
	}

	/**
	 * 指定された社員と部下の深さを設定
	 * 
	 * @param subordinates 部下の一覧の配列
	 * @param depths       すべての社員の深さの配列
	 * @param node         現在処理している社員
	 * @param depth        深さ
	 */
	private static void setDepths(List<Integer>[] subordinates, int[] depths, int node, int depth) {
		depths[node] = depth;
		subordinates[node].forEach(i -> setDepths(subordinates, depths, i, depth + 1));
	}
}
