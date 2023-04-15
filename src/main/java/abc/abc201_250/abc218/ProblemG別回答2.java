package abc.abc201_250.abc218;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc218/editorial/4102 の実装<br/>
 * https://atcoder.jp/contests/abc218/submissions/32331772 にも参考
 */
public class ProblemG別回答2 {

	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			@SuppressWarnings("unchecked")
			List<Integer>[] edges = new List[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, n - 1).forEach(i -> {
				int u = scanner.nextInt() - 1, v = scanner.nextInt() - 1;
				edges[u].add(v);
				edges[v].add(u);
			});
			System.out.println(bisect(n, a, edges, 0, INF));
		}
	}

	/**
	 * 二分探索法で結果を計算する
	 *
	 * @param n     頂点の数
	 * @param a     各頂点に書かれた数字の配列
	 * @param edges 辺の一覧
	 * @param ok    二分探索法の最小値
	 * @param ng    二分探索法の最大値
	 * @return 計算結果
	 */
	private static int bisect(int n, int[] a, List<Integer>[] edges, int ok, int ng) {
		while (ng > ok + 1) {
			int med = (ok + ng) >> 1;
			if (check(n, a, edges, med)) {
				ok = med;
			} else {
				ng = med;
			}
		}
		return ok;
	}

	/**
	 * ゲームが終了するまでに駒が訪れた頂点に書かれた数の集合の中央値が X 以上のとき太郎君の勝ち、 X 未満の時次郎君の勝ちとします。両者が最善を尽くすとき、時次郎君が勝利するかを計算する
	 *
	 * @param n     頂点の数
	 * @param a     各頂点に書かれた数字の配列
	 * @param edges 辺の一覧
	 * @param value Xの値
	 * @return 太郎が勝利するか
	 */
	private static boolean check(int n, int[] a, List<Integer>[] edges, int value) {
		int[] win = new int[n], count = new int[n], upperMin = new int[n], lowerMax = new int[n], taros = new int[n],
				parents = new int[n];
		Arrays.fill(win, -1);
		Arrays.fill(count, 0);
		Arrays.fill(upperMin, INF);
		Arrays.fill(lowerMax, -INF);
		Arrays.fill(taros, -1);
		Arrays.fill(parents, -1);
		if (a[0] > value) {
			count[0] = 1;
			upperMin[0] = a[0];
		} else if (a[0] < value) {
			count[0] = -1;
			lowerMax[0] = a[0];
		} else {
			upperMin[0] = lowerMax[0] = a[0];
		}
		taros[0] = 1;

		Deque<Integer> q = new ArrayDeque<>();
		q.addLast(~0);
		q.addLast(0);
		while (!q.isEmpty()) {
			int x = q.pollLast();
			if (x >= 0) {
				for (int y : edges[x]) {
					if (y != parents[x]) {
						parents[y] = x;
						taros[y] = taros[x] ^ 1;
						q.addLast(~y);
						q.addLast(y);
						if (a[y] > value) {
							count[y] = count[x] + 1;
							upperMin[y] = Math.min(upperMin[x], a[y]);
							lowerMax[y] = lowerMax[x];
						} else if (a[y] < value) {
							count[y] = count[x] - 1;
							upperMin[y] = upperMin[x];
							lowerMax[y] = Math.max(lowerMax[x], a[y]);
						} else {
							count[y] = count[x];
							upperMin[y] = lowerMax[y] = a[y];
						}
					}
				}
			} else {
				x = ~x;
				if ((1 == edges[x].size()) && (0 != x)) {
					if (count[x] > 0) {
						win[x] = 1;
					} else if (count[x] < 0) {
						win[x] = 0;
					} else if (((upperMin[x] + lowerMax[x]) >> 1) >= value) {
						win[x] = 1;
					} else {
						win[x] = 0;
					}
				} else if (0 != taros[x]) {
					win[x] = 0;
					for (int y : edges[x]) {
						if ((y != parents[x]) && (1 == win[y])) {
							win[x] = 1;
							break;
						}
					}
				} else {
					win[x] = 1;
					for (int y : edges[x]) {
						if ((y != parents[x]) && (0 == win[y])) {
							win[x] = 0;
							break;
						}
					}
				}
			}
		}
		return (1 == win[0]);
	}
}
