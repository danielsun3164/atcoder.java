package abc.abc201_250.abc245;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc245/editorial/3698 の実装<br/>
 * https://atcoder.jp/contests/abc245/submissions/30441397 にも参考
 */
public class ProblemG別回答 {

	/** 最大値 */
	static final long INF = 1L << 60;
	static final long EDGE_INF = 1L << 50;

	public static void main(String[] args) throws Exception {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt(), k = scanner.nextInt(), l = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(_ -> scanner.nextInt() - 1).toArray(),
					b = IntStream.range(0, l).map(_ -> scanner.nextInt() - 1).toArray();

			// C++版のNimberの代わりに、XOR演算を使うlongを利用
			long[] countryHash = IntStream.range(0, k).mapToLong(_ -> ThreadLocalRandom.current().nextLong(INF))
					.toArray();

			int source = n << 1;
			ShortestNonzeroPath graph = new ShortestNonzeroPath(source + 1);
			// 仮想始点から、人気都市へ辺を追加
			Arrays.stream(b).forEach(s -> graph.addBiEdge(source, s, EDGE_INF, countryHash[a[s]]));

			// 通常の道路
			IntStream.range(0, m).forEach(i -> {
				int u = scanner.nextInt() - 1, v = scanner.nextInt() - 1;
				long c = scanner.nextLong();
				graph.addBiEdge(u, v, c, 0);
			});

			// 各都市に対応する追加頂点
			IntStream.range(0, n).forEach(i -> graph.addBiEdge(i, n + i, EDGE_INF, countryHash[a[i]]));

			graph.solve(source);
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, n).forEach(i -> {
				sb.append((i > 0) ? " " : "");
				long ret = graph.dist[n + i] - EDGE_INF * 2;
				sb.append(ret < EDGE_INF ? ret : -1);
			});
			System.out.println(sb);
		}
	}

	static class ShortestNonzeroPath {
		int n;
		List<Edge>[] graph;
		long[] shortest, psi, dist;
		int[] parent, depth, uf;
		Queue<Candidate> candidateQueue;

		@SuppressWarnings("unchecked")
		ShortestNonzeroPath(int n) {
			this.n = n;
			graph = new ArrayList[n];
			IntStream.range(0, n).forEach(i -> graph[i] = new ArrayList<>());
		}

		void addBiEdge(int u, int v, long cost, long label) {
			graph[u].add(new Edge(v, cost, label));
			// XOR群では -label = label
			graph[v].add(new Edge(u, cost, label));
		}

		int find(int x) {
			if (uf[x] < 0) {
				return x;
			}
			return uf[x] = find(uf[x]);
		}

		void unite(int root, int x) {
			uf[x] = root;
		}

		void solve(int source) {
			shortest = new long[n];
			Arrays.fill(shortest, INF);

			parent = new int[n];
			Arrays.fill(parent, -1);
			depth = new int[n];
			Arrays.fill(depth, -1);

			psi = new long[n];

			// 通常のダイクストラ法
			Queue<State> pq = new PriorityQueue<>();
			shortest[source] = 0L;
			depth[source] = 0;
			pq.add(new State(0, source));

			while (!pq.isEmpty()) {
				State cur = pq.poll();
				long d = cur.dist;
				int u = cur.vertex;
				if (shortest[u] != d) {
					continue;
				}
				graph[u].forEach(e -> {
					int v = e.to;
					long nd = d + e.cost;
					if (shortest[v] > nd) {
						shortest[v] = nd;
						depth[v] = depth[u] + 1;
						parent[v] = u;
						psi[v] = psi[u] ^ e.label;
						pq.add(new State(nd, v));
					}
				});
			}

			// Union-Findを初期化
			uf = new int[n];
			Arrays.fill(uf, -1);
			dist = new long[n];
			Arrays.fill(dist, INF);

			candidateQueue = new PriorityQueue<>();
			// 最短路木に含まれない辺を候補に登録
			for (int u = 0; u < n; u++) {
				if (shortest[u] == INF) {
					continue;
				}

				for (int i = 0; i < graph[u].size(); i++) {
					Edge e = graph[u].get(i);
					int v = e.to;

					if (u < v && (psi[u] ^ e.label) != psi[v]) {
						candidateQueue.add(new Candidate(shortest[u] + shortest[v] + e.cost, u, i));
					}
				}
			}

			// 非ゼロ経路の距離を求める
			while (!candidateQueue.isEmpty()) {
				Candidate cur = candidateQueue.poll();
				long h = cur.dist;
				int u0 = cur.from, edgeIndex = cur.edgeIndex, v0 = graph[u0].get(edgeIndex).to;
				int u = find(u0), v = find(v0);
				List<Integer> path = new ArrayList<>();
				while (u != v) {
					if (depth[u] > depth[v]) {
						path.add(u);
						u = find(parent[u]);
					} else {
						path.add(v);
						v = find(parent[v]);
					}
				}

				for (int x : path) {
					unite(u, x);
					dist[x] = h - shortest[x];
					IntStream.range(0, graph[x].size()).forEach(i -> {
						// for (int i = 0; i < graph[x].size(); i++) {
						Edge e = graph[x].get(i);
						int y = e.to;
						if ((psi[x] ^ e.label) == psi[y]) {
							candidateQueue.offer(new Candidate(dist[x] + shortest[y] + e.cost, x, i));
						}
					});
				}
			}

			// psiがゼロでない頂点は、通常の最短距離も候補になる
			IntStream.range(0, n).filter(i -> (psi[i] != 0) && (shortest[i] < dist[i]))
					.forEach(i -> dist[i] = shortest[i]);
		}
	}

	static class Edge {
		int to;
		long cost, label;

		Edge(int to, long cost, long label) {
			this.to = to;
			this.cost = cost;
			this.label = label;
		}
	}

	static class State implements Comparable<State> {
		long dist;
		int vertex;

		State(long dist, int vertex) {
			this.dist = dist;
			this.vertex = vertex;
		}

		@Override
		public int compareTo(State other) {
			return (dist == other.dist) ? Integer.compare(vertex, other.vertex) : Long.compare(dist, other.dist);
		}
	}

	static class Candidate implements Comparable<Candidate> {
		long dist;
		int from, edgeIndex;

		Candidate(long dist, int from, int edgeIndex) {
			this.dist = dist;
			this.from = from;
			this.edgeIndex = edgeIndex;
		}

		@Override
		public int compareTo(Candidate other) {
			if (dist == other.dist) {
				return (from == other.from) ? Integer.compare(edgeIndex, other.edgeIndex)
						: Integer.compare(from, other.from);
			} else {
				return Long.compare(dist, other.dist);
			}
		}
	}
}
