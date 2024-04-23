package abc.abc201_250.abc223;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc223/editorial/2806 の実装<br/>
 * https://atcoder.jp/contests/abc223/submissions/26682605 にも参考
 */
public class ProblemG別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Integer>[] edges = new List[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, n - 1).forEach(i -> {
				int u = scanner.nextInt() - 1, v = scanner.nextInt() - 1;
				edges[u].add(v);
				edges[v].add(u);
			});
			// 木を二部グラフに彩色する
			BitSet color = new BitSet(n), check = new BitSet(n + 2);
			Queue<Integer> que = new ArrayDeque<>();
			que.add(0);
			color.set(0, true);
			check.set(0, true);
			while (!que.isEmpty()) {
				int now = que.poll();
				for (int next : edges[now]) {
					if (!check.get(next)) {
						check.set(next, true);
						color.set(next, !color.get(now));
						que.add(next);
					}
				}
			}
			// 木の二部マッチングを求め、辺を貼る
			@SuppressWarnings("unchecked")
			List<Integer>[] flow = new List[n + 2];
			IntStream.range(0, n + 2).forEach(i -> flow[i] = new ArrayList<>());
			check.clear();
			int[] degree = IntStream.range(0, n).map(i -> {
				int size = edges[i].size();
				if (1 == size) {
					que.add(i);
				}
				return size;
			}).toArray();
			main: while (!que.isEmpty()) {
				int now = que.poll();
				if (!check.get(now)) {
					check.set(now, true);
					for (int next : edges[now]) {
						if (!check.get(next)) {
							check.set(next, true);
							if (color.get(now)) {
								flow[n + 1].add(next);
								flow[now].add(n);
								flow[next].add(now);
								for (int next2 : edges[next]) {
									if (next2 != now) {
										flow[next2].add(next);
										if (1 == (--degree[next2])) {
											que.add(next2);
										}
									}
								}
								continue main;
							} else {
								flow[n + 1].add(now);
								flow[now].add(next);
								flow[next].add(n);
								for (int next2 : edges[next]) {
									if (next2 != now) {
										flow[next].add(next2);
										if (1 == (--degree[next2])) {
											que.add(next2);
										}
									}
								}
								continue main;
							}
						}
					}
					if (color.get(now)) {
						flow[n].add(now);
					} else {
						flow[now].add(n + 1);
					}
				}
			}
			// nから到達可能な頂点を求める
			check(n, check, flow);
			int answer = (int) IntStream.range(0, n).filter(i -> color.get(i) && check.get(i)).count();
			// n+1から到達可能な頂点を求める
			@SuppressWarnings("unchecked")
			List<Integer>[] revFlow = new List[n + 2];
			IntStream.range(0, n + 2).forEach(i -> revFlow[i] = new ArrayList<>());
			IntStream.range(0, n + 2).forEach(i -> flow[i].forEach(j -> revFlow[j].add(i)));
			check(n + 1, check, revFlow);
			answer += IntStream.range(0, n).filter(i -> !color.get(i) && check.get(i)).count();
			System.out.println(answer);
		}
	}

	/**
	 * sから到達可能な頂点を求める
	 *
	 * @param s     開始頂点
	 * @param check 到達できるかの配列
	 * @param flow  辺の一覧
	 */
	private static void check(int s, BitSet check, List<Integer>[] flow) {
		check.clear();
		check.set(s, true);
		Queue<Integer> que = new ArrayDeque<>();
		que.add(s);
		while (!que.isEmpty()) {
			int now = que.poll();
			for (int next : flow[now]) {
				if (!check.get(next)) {
					check.set(next, true);
					que.add(next);
				}
			}
		}
	}
}
