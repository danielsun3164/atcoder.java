package abc.abc151_200.abc164;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc164/submissions/12384200 にも参考
 */
public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt(), s = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Path>[] paths = new List[n];
			IntStream.range(0, n).forEach(i -> paths[i] = new ArrayList<>());
			int[] a = new int[m];
			IntStream.range(0, m).forEach(i -> {
				int u = scanner.nextInt() - 1, v = scanner.nextInt() - 1;
				a[i] = scanner.nextInt();
				long b = scanner.nextLong();
				paths[u].add(new Path(u, v, a[i], b));
				paths[v].add(new Path(v, u, a[i], b));
			});
			int[] c = new int[n], d = new int[n];
			IntStream.range(0, n).forEach(i -> {
				c[i] = scanner.nextInt();
				d[i] = scanner.nextInt();
			});
			final int maxS = Arrays.stream(a).max().getAsInt() * (n - 1);
			long[][] times = new long[n][maxS + 1];
			IntStream.range(0, n).forEach(i -> Arrays.fill(times[i], Long.MAX_VALUE));
			Queue<State> queue = new PriorityQueue<>((x, y) -> Long.compare(x.s, y.s));
			queue.add(new State(0, 0, s));
			while (!queue.isEmpty()) {
				State state = queue.poll();
				int nowS = (int) Math.min(state.s, maxS);
				if (times[state.node][nowS] > state.time) {
					times[state.node][nowS] = state.time;
					if (state.s < maxS) {
						queue.add(new State(state.node, state.time + d[state.node], state.s + c[state.node]));
					}
					for (Path path : paths[state.node]) {
						long nextTime = state.time + path.time;
						long nextS = state.s - path.cost;
						if (nextS >= 0) {
							queue.add(new State(path.to, nextTime, nextS));
						}
					}
				}
			}
			IntStream.range(1, n).mapToLong(i -> Arrays.stream(times[i]).min().getAsLong())
					.forEach(System.out::println);
		}
	}

	/**
	 * ノード間の一つのパスを表すクラス
	 */
	private static class Path {
		/** 開始ノード */
		@SuppressWarnings("unused")
		int from;
		/** 終了ノード */
		int to;
		/** 移動コスト */
		int cost;
		/** 移動時間 */
		long time;

		/**
		 * コンストラクタ
		 *
		 * @param from 開始ノード
		 * @param to   終了ノード
		 * @param cost 移動コスト
		 * @param time 移動時間
		 */
		Path(int from, int to, int cost, long time) {
			this.from = from;
			this.to = to;
			this.cost = cost;
			this.time = time;
		}
	}

	/**
	 * 状態を表すクラス
	 */
	private static class State {
		/** 現在の所在ノード */
		int node;
		/** 現在までかかった時間 */
		long time;
		/** 所持金 */
		long s;

		/**
		 * コンストラクター
		 *
		 * @param node 現在の所在ノード
		 * @param time 現在までかかった時間
		 * @param s    所持金
		 */
		State(int node, long time, long s) {
			this.node = node;
			this.time = time;
			this.s = s;
		}
	}
}
