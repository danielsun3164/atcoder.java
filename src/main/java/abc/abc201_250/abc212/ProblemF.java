package abc.abc201_250.abc212;

import java.util.Arrays;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * ダブリングの実装
 */
public class ProblemF {

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
			int[][] dp = calcDp(m, maps, buses);
			// TLE対策のため、結果をStringBuilderにまとめる
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, q).forEach(i -> {
				int x = scanner.nextInt(), y = scanner.nextInt(), z = scanner.nextInt();
				sb.append(getResult(m, maps, buses, dp, x, y, z)).append(System.lineSeparator());
			});
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * ダブリング を計算する
	 *
	 * @param m     バスの運行数
	 * @param maps  バスの運行情報のマップの一覧
	 * @param buses バスの運行情報一覧
	 * @return ダブリング
	 */
	private static int[][] calcDp(int m, TreeMap<Integer, Integer>[] maps, Bus[] buses) {
		int[][] dp = new int[m][20];
		IntStream.range(0, m).forEach(i -> Arrays.fill(dp[i], 0));
		IntStream.range(0, m).forEach(i -> {
			Entry<Integer, Integer> entry = maps[buses[i].to].ceilingEntry(buses[i].t);
			dp[i][0] = (null == entry) ? i : entry.getValue();
		});
		IntStream.range(1, 20).forEach(i -> IntStream.range(0, m).forEach(j -> dp[j][i] = dp[dp[j][i - 1]][i - 1]));
		return dp;
	}

	/**
	 * 現在の時刻と現在の所在都市から目標時刻に高橋くんの所在を計算する
	 *
	 * @param m     バスの運行数
	 * @param maps  バスの運行情報のマップの一覧
	 * @param dp    ダブリング
	 * @param buses バスの運行情報一覧
	 * @param x     現在の時刻
	 * @param y     現在の所在都市
	 * @param z     目標時刻
	 * @return 目標時刻に高橋くんの所在
	 */
	private static String getResult(int m, TreeMap<Integer, Integer>[] maps, Bus[] buses, int[][] dp, int x, int y,
			int z) {
		Entry<Integer, Integer> entry = maps[y].ceilingEntry(x);
		if (null == entry) {
			return "" + y;
		}
		Bus bus = buses[entry.getValue()];
		if (z <= bus.s) {
			return "" + y;
		}
		if (z <= bus.t) {
			return y + " " + bus.to;
		}
		int left = 0, right = m;
		while (right - left > 1) {
			int mid = (left + right) >> 1, now = entry.getValue(), value = mid, index = 0;
			while (value > 0) {
				if (1 == (1 & value)) {
					now = dp[now][index];
				}
				value >>= 1;
				index++;
			}
			if (buses[now].t < z) {
				left = mid;
			} else {
				right = mid;
			}
		}
		int value = left, index = 0, now = entry.getValue();
		while (value > 0) {
			if (1 == (1 & value)) {
				now = dp[now][index];
			}
			value >>= 1;
			index++;
		}
		entry = maps[buses[now].to].ceilingEntry(buses[now].t);
		if (null == entry) {
			return "" + buses[now].to;
		}
		bus = buses[entry.getValue()];
		if (z <= bus.s) {
			return "" + buses[now].to;
		} else {
			return bus.from + " " + bus.to;
		}
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
