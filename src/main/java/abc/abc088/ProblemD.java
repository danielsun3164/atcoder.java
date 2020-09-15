package abc.abc088;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemD {

	/** 白のコマ */
	private static final char WHITE = '.';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt();
			boolean[][] s = new boolean[h + 1][w + 1];
			IntStream.range(0, h + 1).forEach(i -> Arrays.fill(s[i], false));
			int whiteCount = 0;
			@SuppressWarnings("unchecked")
			List<Path>[] pathLists = new List[h * w];
			IntStream.range(0, h * w).forEach(i -> pathLists[i] = new ArrayList<>());
			for (int i = 1; i <= h; i++) {
				char[] l = scanner.next().toCharArray();
				for (int j = 1; j <= w; j++) {
					s[i][j] = (l[j - 1] == WHITE);
					if (s[i][j]) {
						whiteCount++;
						int now = (i - 1) * w + j - 1;
						if (s[i - 1][j]) {
							int before = (i - 2) * w + j - 1;
							pathLists[now].add(new Path(now, before, 1));
							pathLists[before].add(new Path(before, now, 1));
						}
						if (s[i][j - 1]) {
							int before = (i - 1) * w + j - 2;
							pathLists[now].add(new Path(now, before, 1));
							pathLists[before].add(new Path(before, now, 1));
						}
					}
				}
			}
			int[] distances = dijkstra(pathLists, 0, h * w);
			System.out.println((distances[h * w - 1] < Integer.MAX_VALUE) ? whiteCount - distances[h * w - 1] - 1 : -1);
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
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Path path) {
			return this.cost - path.cost;
		}
	}
}
