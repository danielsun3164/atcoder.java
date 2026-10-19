package abc.abc201_250.abc245;

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
 * https://atcoder.jp/contests/abc245/editorial/3662 の実装
 */
public class ProblemG {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			@SuppressWarnings("unused")
			int n = scanner.nextInt(), m = scanner.nextInt(), k = scanner.nextInt(), l = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(_ -> scanner.nextInt()).toArray();
			Queue<Path> que = new PriorityQueue<>((x, y) -> Long.compare(y.cost, x.cost));
			IntStream.range(0, l).forEach(_ -> {
				int b = scanner.nextInt() - 1;
				que.add(new Path(b, a[b], 0L));
			});
			@SuppressWarnings("unchecked")
			List<Path>[] edges = new List[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, m).forEach(_ -> {
				int u = scanner.nextInt() - 1, v = scanner.nextInt() - 1;
				long c = scanner.nextLong();
				edges[u].add(new Path(v, a[v], c));
				edges[v].add(new Path(u, a[u], c));
			});
			int[] count = new int[n], country = new int[n];
			Arrays.fill(count, 0);
			long[] d = new long[n], d2 = new long[n];
			Arrays.fill(d, -1L);
			Arrays.fill(d2, -1L);
			while (!que.isEmpty()) {
				Path now = que.poll();
				int x = now.to, y = now.country;
				long z = now.cost;
				if (0 == count[x]) {
					d[x] = -z;
					country[x] = y;
				} else if ((1 == count[x]) && (y != country[x])) {
					d2[x] = -z;
				} else {
					continue;
				}
				count[x]++;
				edges[x].forEach(p -> que.add(new Path(p.to, y, z - p.cost)));
			}
			IntStream.range(0, n)
					.forEach(i -> System.out.print(((i > 0) ? " " : "") + ((a[i] != country[i]) ? d[i] : d2[i])));
			System.out.println();
		}
	}

	/**
	 * to,country,costを格納するクラス
	 */
	private static class Path {
		int to, country;
		long cost;

		Path(int to, int country, long cost) {
			this.to = to;
			this.country = country;
			this.cost = cost;
		}
	}
}
