package abc.abc051_100.abc065;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * https://atcoder.jp/contests/abc065/submissions/3882674 を参考に作成
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Node[] nodes = new Node[n];
			IntStream.range(0, n).forEach(i -> nodes[i] = new Node(i, scanner.nextInt(), scanner.nextInt()));
			// X座標でソート
			Arrays.sort(nodes, (n1, n2) -> n1.x - n2.x);
			IntStream.range(0, n - 1).forEach(i -> {
				nodes[i].edges.add(new Edge(nodes[i], nodes[i + 1], nodes[i + 1].x - nodes[i].x));
				nodes[i + 1].edges.add(new Edge(nodes[i + 1], nodes[i], nodes[i + 1].x - nodes[i].x));
			});
			// Y座標でソート
			Arrays.sort(nodes, (n1, n2) -> n1.y - n2.y);
			IntStream.range(0, n - 1).forEach(i -> {
				nodes[i].edges.add(new Edge(nodes[i], nodes[i + 1], nodes[i + 1].y - nodes[i].y));
				nodes[i + 1].edges.add(new Edge(nodes[i + 1], nodes[i], nodes[i + 1].y - nodes[i].y));
			});
			System.out.println(getResult(nodes[0], n));
		}
	}

	/**
	 * @param src 開始ノード
	 * @param n   町の数
	 * @return srcの町からすべての町への道路の最小コスト
	 */
	private static long getResult(Node src, int n) {
		BitSet visited = new BitSet(n);
		Queue<Edge> queue = new PriorityQueue<>((e1, e2) -> e1.cost - e2.cost);
		queue.addAll(src.edges);
		visited.set(src.id, true);
		long result = 0L;
		while (!queue.isEmpty()) {
			Edge edge = queue.poll();
			if (!visited.get(edge.to.id)) {
				result += edge.cost;
				visited.set(edge.to.id, true);
				queue.addAll(edge.to.edges);
			}
		}
		return result;
	}

	/**
	 * ノードを格納するクラス
	 */
	private static final class Node {
		final int id;
		final int x;
		final int y;
		List<Edge> edges = new ArrayList<>();

		Node(int id, int x, int y) {
			this.id = id;
			this.x = x;
			this.y = y;
		}
	}

	/**
	 * 辺を表すクラス
	 */
	private static final class Edge {
		/** 始点 */
		@SuppressWarnings("unused")
		final Node from;
		/** 終点 */
		final Node to;
		/** コスト */
		final int cost;

		Edge(Node from, Node to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
}
