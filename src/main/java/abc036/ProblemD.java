package abc036;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード<br/>
 * https://atcoder.jp/contests/abc036/submissions/4293321 にも参考
 */
public class ProblemD {

	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Node[] nodes = new Node[n];
			IntStream.range(0, n).forEach(i -> nodes[i] = new Node());
			IntStream.range(0, n - 1).forEach(i -> {
				int a = scanner.nextInt() - 1;
				int b = scanner.nextInt() - 1;
				nodes[a].neighbors.add(nodes[b]);
				nodes[b].neighbors.add(nodes[a]);
			});
			long[] count = dfs(nodes[0]);
			System.out.println((count[0] + count[1]) % MOD);
		}
	}

	/**
	 * @param node
	 * @return 黒に塗り方数、白の塗り方数 の配列
	 */
	private static long[] dfs(Node node) {
		node.visited = true;
		long[] result = new long[] { 1L, 1L };
		node.neighbors.stream().filter(n -> !n.visited).forEach(n -> {
			long[] count = dfs(n);
			result[0] = result[0] * ((count[0] + count[1]) % MOD) % MOD;
			result[1] = result[1] * count[0] % MOD;
		});
		return result;
	}

	/**
	 * ノードを表すクラス
	 */
	private static class Node {
		/** 隣のノード一覧 */
		List<Node> neighbors = new ArrayList<>();
		/** 処理したかどうか */
		boolean visited = false;
	}
}
