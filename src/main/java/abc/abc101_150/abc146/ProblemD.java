package abc.abc101_150.abc146;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Path>[] pathLists = new List[n];
			IntStream.range(0, n).forEach(i -> pathLists[i] = new ArrayList<>());
			Path[] paths = new Path[n - 1];
			IntStream.range(0, n - 1).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				paths[i] = new Path(a, b);
				pathLists[a].add(paths[i]);
				pathLists[b].add(paths[i]);
			});
			int maxColor = 0, maxColorNode = 0;
			for (int node = 0; node < n; node++) {
				if (pathLists[node].size() > maxColor) {
					maxColor = pathLists[node].size();
					maxColorNode = node;
				}
			}
			paint(maxColorNode, pathLists, new boolean[n]);
			System.out.println(maxColor);
			Arrays.stream(paths).forEach(path -> System.out.println(path.color));
		}
	}

	/**
	 * 各辺に色を塗る
	 *
	 * @param node      対象となるノード
	 * @param pathLists 辺の一覧
	 * @param visited   各ノードが塗ったかどうかの配列
	 */
	private static void paint(int node, final List<Path>[] pathLists, boolean[] visited) {
		if (!visited[node]) {
			int color = 1;
			Set<Integer> colorSet = pathLists[node].stream().filter(path -> path.color != 0).map(path -> path.color)
					.collect(Collectors.toSet());
			for (Path path : pathLists[node]) {
				if (colorSet.contains(color)) {
					color++;
				}
				if (path.color == 0) {
					path.color = color;
					color++;
				}
			}
			visited[node] = true;
			// 現在のノードにつながったすべてのノードの辺を塗る
			for (Path path : pathLists[node]) {
				paint(path.getNextNode(node), pathLists, visited);
			}
		}
	}

	/**
	 * ノード間の一つのパスを表すクラス
	 */
	private static class Path {
		int node1;
		int node2;
		/** 色 */
		int color;

		Path(int node1, int node2) {
			this.node1 = node1;
			this.node2 = node2;
			color = 0;
		}

		/**
		 * 現在のノードから次のノードを取得する
		 *
		 * @param currentNode 現在のノード
		 * @return 次のノード
		 */
		int getNextNode(int currentNode) {
			if (currentNode == node1) {
				return node2;
			} else {
				return node1;
			}
		}
	}
}
