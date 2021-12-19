package abc.abc201_250.abc212;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * グラフが根付き木の形の実装
 */
public class ProblemF別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt(), q = scanner.nextInt();
			@SuppressWarnings("unchecked")
			TreeMap<Integer, Integer>[] maps = new TreeMap[n + 1];
			IntStream.range(0, n + 1).forEach(i -> maps[i] = new TreeMap<>());
			Bus[] buses = new Bus[m];
			IntStream.range(0, m).forEach(i -> {
				int a = scanner.nextInt(), b = scanner.nextInt(), s = scanner.nextInt(), t = scanner.nextInt();
				buses[i] = new Bus(a, b, s, t);
				maps[a].put(s, i);
			});
			@SuppressWarnings("unchecked")
			List<Integer>[] edges = new List[m];
			IntStream.range(0, m).forEach(i -> edges[i] = new ArrayList<>());
			boolean[] isRoot = new boolean[m];
			Arrays.fill(isRoot, false);
			IntStream.range(0, m).forEach(i -> {
				Entry<Integer, Integer> entry = maps[buses[i].to].ceilingEntry(buses[i].t);
				if (null == entry) {
					isRoot[i] = true;
				} else {
					edges[entry.getValue()].add(i);
				}
			});
			int[] x = new int[q], y = new int[q], z = new int[q];
			String[] answers = new String[q];
			@SuppressWarnings("unchecked")
			List<Integer>[] memo = new List[m];
			IntStream.range(0, m).forEach(i -> memo[i] = new ArrayList<>());
			IntStream.range(0, q).forEach(i -> {
				x[i] = scanner.nextInt();
				y[i] = scanner.nextInt();
				z[i] = scanner.nextInt();
				Entry<Integer, Integer> entry = maps[y[i]].ceilingEntry(x[i]);
				if ((null == entry) || (z[i] <= entry.getKey())) {
					answers[i] = "" + y[i];
				} else {
					memo[entry.getValue()].add(i);
				}
			});
			List<Integer> time = new ArrayList<>(), city = new ArrayList<>();
			IntStream.range(0, m).filter(i -> isRoot[i])
					.forEach(i -> dfs(buses, edges, z, memo, time, city, answers, i));
			// TLE対策のため、結果をStringBuilderにまとめる
			StringBuilder sb = new StringBuilder();
			Arrays.stream(answers).forEach(s -> sb.append(s).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * 結果を計算する
	 *
	 * @param buses   バスの運行情報一覧
	 * @param edges   グラフの辺の一覧
	 * @param z       問題の時刻一覧
	 * @param memo    計算用メモ
	 * @param time    時刻一覧
	 * @param city    都市一覧
	 * @param answers 計算結果一覧
	 * @param now     現在の計算対象
	 */
	private static void dfs(Bus[] buses, List<Integer>[] edges, int[] z, List<Integer>[] memo, List<Integer> time,
			List<Integer> city, String[] answers, int now) {
		time.add(buses[now].t);
		time.add(buses[now].s);
		city.add(buses[now].to);
		city.add(buses[now].from);
		for (int i : memo[now]) {
			int index = rLowerBound(time, z[i]);
			if (-1 == index) {
				answers[i] = "" + city.get(0);
			} else if (1 == (index & 1)) {
				answers[i] = "" + city.get(index);
			} else {
				answers[i] = city.get(index + 1) + " " + city.get(index);
			}
		}
		for (int next : edges[now]) {
			dfs(buses, edges, z, memo, time, city, answers, next);
		}
		time.remove(time.size() - 1);
		time.remove(time.size() - 1);
		city.remove(city.size() - 1);
		city.remove(city.size() - 1);
	}

	/**
	 * 逆順のlower_boundのJava実装
	 *
	 * @param list  検索対象リスト
	 * @param value 検索対象値
	 * @return 逆順のlower_bound
	 */
	private static int rLowerBound(List<Integer> list, int value) {
		int index = Collections.binarySearch(list, value, (x, y) -> (x.compareTo(y) >= 0) ? -1 : 1);
		return ~index - 1;
	}

	/**
	 * バスの運行情報を表すクラス
	 */
	private static class Bus {
		int from, to, s, t;

		Bus(int from, int to, int s, int t) {
			super();
			this.from = from;
			this.to = to;
			this.s = s;
			this.t = t;
		}
	}
}
