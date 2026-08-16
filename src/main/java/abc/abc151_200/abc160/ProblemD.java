package abc.abc151_200.abc160;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Path>[] paths = new List[n];
			IntStream.range(0, n).forEach(i -> paths[i] = new ArrayList<>());
			IntStream.range(0, n - 1).forEach(i -> {
				paths[i].add(new Path(i, i + 1, 1));
				paths[i + 1].add(new Path(i + 1, i, 1));
			});
			int x = scanner.nextInt() - 1, y = scanner.nextInt() - 1;
			paths[x].add(new Path(x, y, 1));
			paths[y].add(new Path(y, x, 1));
			int[][] costs = new int[n][];
			IntStream.range(0, n).forEach(i -> costs[i] = dijkstra(paths, i, n));
			int[] answer = new int[n - 1];
			Arrays.fill(answer, 0);
			IntStream.range(0, n).forEach(i -> IntStream.range(0, i).forEach(j -> answer[costs[i][j] - 1]++));
			// TLE対策のため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			Arrays.stream(answer).forEach(ai -> sb.append(ai).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * @param pathLists ノード間の連結パス一覧の配列
	 * @param src       開始ノード
	 * @param n         ノードの数
	 * @return 開始ノードからの距離の配列
	 */
	private static int[] dijkstra(List<Path>[] pathLists, int src, int n) {
		int[] distances = new int[n];
		Arrays.fill(distances, Integer.MAX_VALUE);
		// 最短距離が確定したかどうか
		boolean[] fixed = new boolean[n];
		Arrays.fill(fixed, false);
		// 出発地点までの距離を0とする
		distances[src] = 0;
		Queue<Path> queue = new PriorityQueue<>();
		queue.add(new Path(src, src, 0));
		while (!queue.isEmpty()) {
			int now = queue.poll().to;
			if (!fixed[now]) {
				fixed[now] = true;
				for (Path path : pathLists[now]) {
					if (!fixed[path.to] && distances[path.to] > distances[now] + path.cost) {
						distances[path.to] = distances[now] + path.cost;
						queue.add(new Path(path.to, path.to, distances[path.to]));
					}
				}
			}
		}
		return distances;
	}

	/**
	 * ノード間の一つのパスを表すクラス
	 */
	private static class Path implements Comparable<Path> {
		/** 開始ノード */
		@SuppressWarnings("unused")
		int from;
		/** 終了ノード */
		int to;
		/** 移動コスト */
		int cost;

		Path(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Path path) {
			return cost - path.cost;
		}
	}
}
