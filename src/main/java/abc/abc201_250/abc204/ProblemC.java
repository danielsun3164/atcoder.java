package abc.abc201_250.abc204;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Integer>[] childrenLists = new List[n];
			IntStream.range(0, n).forEach(i -> childrenLists[i] = new ArrayList<>());
			IntStream.range(0, m).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				childrenLists[a].add(b);
			});
			System.out.println(IntStream.range(0, n).map(i -> {
				int[] dist = dijkstra(childrenLists, i, n);
				return (int) Arrays.stream(dist).filter(di -> INF != di).count();
			}).sum());
		}
	}

	/**
	 * @param childrenLists ノード間の連結パス一覧の配列
	 * @param src           開始ノード
	 * @param n             ノードの数
	 * @return 開始ノードからの距離の配列
	 */
	private static int[] dijkstra(List<Integer>[] childrenLists, int src, int n) {
		int[] dist = new int[n];
		Arrays.fill(dist, INF);
		dist[src] = 0;
		Queue<Path> que = new ArrayDeque<>();
		que.add(new Path(src, 0));
		while (!que.isEmpty()) {
			Path path = que.poll();
			if (path.cost == dist[path.to]) {
				for (int next : childrenLists[path.to]) {
					if (INF == dist[next]) {
						dist[next] = dist[path.to] + 1;
						que.add(new Path(next, dist[next]));
					}
				}
			}
		}
		return dist;
	}

	/**
	 * パスを表すクラス
	 */
	private static class Path {
		int to, cost;

		Path(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}
	}
}
