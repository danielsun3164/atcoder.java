package abc.abc201_250.abc241;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc241/editorial/3451 の実装<br/>
 * https://atcoder.jp/contests/abc241/submissions/29670996 にも参考
 */
public class ProblemF {

	/** X座標の差分 */
	private static final int[] DX = { 1, -1, 0, 0 };
	/** Y座標の差分 */
	private static final int[] DY = { 0, 0, 1, -1 };
	/** 最大値 */
	private static final long INF = Long.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt(), n = scanner.nextInt();
			Data s = new Data(scanner.nextInt(), scanner.nextInt()), g = new Data(scanner.nextInt(), scanner.nextInt());
			int[] x = new int[n], y = new int[n];
			IntStream.range(0, n).forEach(i -> {
				x[i] = scanner.nextInt();
				y[i] = scanner.nextInt();
			});
			Set<Data> set = new HashSet<>();
			set.add(s);
			set.add(g);
			IntStream.range(0, n).forEach(i -> IntStream.range(0, DX.length).forEach(j -> {
				int nx = x[i] + DX[j], ny = y[i] + DY[j];
				if ((nx > 0) && (nx <= h) && (ny > 0) && (ny <= w)) {
					set.add(new Data(nx, ny));
				}
			}));
			int m = set.size();
			Data[] datas = set.stream().sorted().toArray(Data[]::new);
			long[] dist = new long[m];
			Arrays.fill(dist, INF);
			Queue<Integer> que = new ArrayDeque<>();
			int index = num(datas, s);
			que.add(index);
			dist[index] = 0L;
			Map<Integer, List<Integer>> bh = new HashMap<>(), bw = new HashMap<>();
			IntStream.range(0, n).forEach(i -> {
				bh.putIfAbsent(x[i], new ArrayList<>());
				bh.get(x[i]).add(y[i]);
				bw.putIfAbsent(y[i], new ArrayList<>());
				bw.get(y[i]).add(x[i]);
			});
			bh.entrySet().forEach(entry -> entry.getValue().sort(Comparator.naturalOrder()));
			bw.entrySet().forEach(entry -> entry.getValue().sort(Comparator.naturalOrder()));

			while (!que.isEmpty()) {
				int now = que.poll();
				if (bh.containsKey(datas[now].x)) {
					List<Integer> poss = calc(bh.get(datas[now].x), datas[now].y);
					poss.forEach(py -> {
						int nm = num(datas, new Data(datas[now].x, py));
						if ((nm >= 0) && (dist[nm] > dist[now] + 1)) {
							dist[nm] = dist[now] + 1;
							que.add(nm);
						}
					});
				}
				if (bw.containsKey(datas[now].y)) {
					List<Integer> poss = calc(bw.get(datas[now].y), datas[now].x);
					poss.forEach(px -> {
						int nm = num(datas, new Data(px, datas[now].y));
						if ((nm >= 0) && (dist[nm] > dist[now] + 1)) {
							dist[nm] = dist[now] + 1;
							que.add(nm);
						}
					});
				}
			}
			int goal = num(datas, g);
			System.out.println((dist[goal] != INF) ? dist[goal] : -1L);
		}
	}

	private static int num(Data[] datas, Data value) {
		int index = Arrays.binarySearch(datas, value);
		return (index < 0) ? ~index : index;
	}

	private static int num(List<Integer> list, Integer value) {
		int index = Collections.binarySearch(list, value);
		return (index < 0) ? ~index : index;
	}

	private static List<Integer> calc(List<Integer> list, int value) {
		List<Integer> result = new ArrayList<>();
		int p = num(list, value);
		IntStream.range(p - 1, p + 1).filter(i -> (i >= 0) && (i < list.size())).forEach(i -> {
			result.add((i == p - 1) ? list.get(i) + 1 : list.get(i) - 1);
		});
		return result;
	}

	/**
	 * x,y を格納するクラス
	 */
	private static class Data implements Comparable<Data> {
		int x, y;

		Data(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Data data) {
				return (x == data.x) && (y == data.y);
			}
			return super.equals(obj);
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}

		@Override
		public int compareTo(Data o) {
			return (x == o.x) ? Integer.compare(y, o.y) : Integer.compare(x, o.x);
		}
	}
}
