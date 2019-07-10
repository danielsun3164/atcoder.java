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
			dfs(nodes[0]);
			System.out.println((nodes[0].white + nodes[0].black) % MOD);
		}
	}

	/**
	 * 指定されたノードを白く塗る方法の数と黒く塗る方法の数を計算する
	 * 
	 * @param node ノード
	 */
	private static void dfs(Node node) {
		node.visited = true;
		node.neighbors.stream().filter(n -> !n.visited).forEach(n -> {
			dfs(n);
			node.white = node.white * ((n.white + n.black) % MOD) % MOD;
			node.black = node.black * n.white % MOD;
		});
	}

	/**
	 * ノードを表すクラス
	 */
	private static class Node {
		/** 隣のノード一覧 */
		List<Node> neighbors = new ArrayList<>();
		/** 処理したかどうか */
		boolean visited = false;
		/** ノードを白く塗る方法の数 */
		long white = 1L;
		/** ノードを黒く塗る方法の数 */
		long black = 1L;
	}
}
