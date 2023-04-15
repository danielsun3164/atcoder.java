package abc.abc201_250.abc218;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class ProblemG {

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
			@SuppressWarnings("unchecked")
			NavigableMap<Integer, Integer>[] maps = new NavigableMap[2];
			IntStream.range(0, 2).forEach(i -> maps[i] = new TreeMap<>());
			boolean[] used = new boolean[n];
			Arrays.fill(used, false);
			used[0] = true;
			int[] counts = new int[2];
			Arrays.fill(counts, 0);
			add(maps, counts, a[0]);
			System.out.println(calc(n, a, edges, maps, counts, used, 0, true));
		}
	}

	/**
	 * 現在の頂点の処理結果を求める
	 *
	 * @param n      頂点の数
	 * @param a      Aの値の配列
	 * @param edges  辺の一覧
	 * @param maps   中央値計算用Mapの配列
	 * @param counts 中央地計算用Mapにある数字の配列
	 * @param used   頂点が使われたかどうかの配列
	 * @param now    現在処理中の頂点
	 * @param max    最大値を計算するかどうか（falseのとき最小値を計算する）
	 * @return 現在の頂点の処理結果
	 */
	private static int calc(int n, int[] a, List<Integer>[] edges, NavigableMap<Integer, Integer>[] maps, int[] counts,
			boolean[] used, int now, boolean max) {
		if (edges[now].stream().filter(next -> !used[next]).count() > 0) {
			int result = max ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			for (int next : edges[now]) {
				if (!used[next]) {
					used[next] = true;
					add(maps, counts, a[next]);
					int nextResult = calc(n, a, edges, maps, counts, used, next, !max);
					result = max ? Math.max(result, nextResult) : Math.min(result, nextResult);
					remove(maps, counts, a[next]);
					used[next] = false;
				}
			}
			return result;
		}
		return getMiddleValue(maps, counts);
	}

	/**
	 * 中央値計算用Mapの配列に指定された値を追加する
	 *
	 * @param maps   中央値計算用Mapの配列
	 * @param counts 中央地計算用Mapにある数字の配列
	 * @param value  値
	 */
	private static void add(NavigableMap<Integer, Integer>[] maps, int[] counts, int value) {
		if (0 == counts[1]) {
			maps[0].put(value, maps[0].getOrDefault(value, 0) + 1);
			counts[0]++;
		} else {
			if (value <= maps[0].lastKey()) {
				maps[0].put(value, maps[0].getOrDefault(value, 0) + 1);
				counts[0]++;
			} else {
				maps[1].put(value, maps[1].getOrDefault(value, 0) + 1);
				counts[1]++;
			}
		}
		adjust(maps, counts);
	}

	/**
	 * 中央値計算用Mapの配列に指定された値を削除する
	 *
	 * @param maps   中央値計算用Mapの配列
	 * @param counts 中央地計算用Mapにある数字の配列
	 * @param value  値
	 */
	private static void remove(NavigableMap<Integer, Integer>[] maps, int[] counts, int value) {
		int index = maps[0].containsKey(value) ? 0 : 1;
		if (maps[index].get(value).equals(1)) {
			maps[index].remove(value);
		} else {
			maps[index].put(value, maps[index].get(value) - 1);
		}
		counts[index]--;
		adjust(maps, counts);
	}

	/**
	 * 中央値計算用Mapの配列から中央値を取得する
	 *
	 * @param maps   中央値計算用Mapの配列
	 * @param counts 中央地計算用Mapにある数字の配列
	 * @return 中央値
	 */
	private static int getMiddleValue(NavigableMap<Integer, Integer>[] maps, int[] counts) {
		adjust(maps, counts);
		if (counts[0] == counts[1]) {
			return (maps[0].lastKey() + maps[1].firstKey()) >> 1;
		} else {
			return maps[0].lastKey();
		}
	}

	/**
	 * 中央値を計算するため、Mapの配列にある要素数を調整する
	 *
	 * @param maps   中央値計算用Mapの配列
	 * @param counts 中央地計算用Mapにある数字の配列
	 */
	private static void adjust(NavigableMap<Integer, Integer>[] maps, int[] counts) {
		while (counts[0] > counts[1] + 1) {
			Entry<Integer, Integer> entry = maps[0].lastEntry();
			transfer(maps, counts, entry, 0, 1, 0);
		}
		while (counts[0] < counts[1]) {
			Entry<Integer, Integer> entry = maps[1].firstEntry();
			transfer(maps, counts, entry, 1, 0, (1 & (counts[0] + counts[1])));
		}
	}

	/**
	 * 指定されたentryをfromのMapからtoのMapへ移動する
	 *
	 * @param maps   中央値計算用Mapの配列
	 * @param counts 中央地計算用Mapにある数字の配列
	 * @param entry  移動するentry
	 * @param from   移動元
	 * @param to     移動先
	 * @param adjust 調整値
	 */
	private static void transfer(NavigableMap<Integer, Integer>[] maps, int[] counts, Entry<Integer, Integer> entry,
			int from, int to, int adjust) {
		if (entry.getValue() > ((counts[from] - counts[to]) >> 1) + adjust) {
			int diff = ((counts[from] - counts[to]) >> 1) + adjust;
			counts[from] -= diff;
			maps[from].put(entry.getKey(), entry.getValue() - diff);
			maps[to].put(entry.getKey(), maps[to].getOrDefault(entry.getKey(), 0) + diff);
			counts[to] += diff;
		} else {
			counts[from] -= entry.getValue();
			maps[from].remove(entry.getKey());
			maps[to].put(entry.getKey(), maps[to].getOrDefault(entry.getKey(), 0) + entry.getValue());
			counts[to] += entry.getValue();
		}
	}
}
