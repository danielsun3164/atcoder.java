package other.typical90;

import java.util.Arrays;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class Problem037 {

	/** 初期値 */
	private static final long INF = -(Long.MAX_VALUE >> 1);

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int w = scanner.nextInt(), n = scanner.nextInt();
			Data[] datas = IntStream.range(0, n)
					.mapToObj(i -> new Data(scanner.nextInt(), scanner.nextInt(), scanner.nextLong()))
					.toArray(Data[]::new);
			long[][] dp = new long[n + 1][w + 1];
			IntStream.rangeClosed(0, n).forEach(i -> Arrays.fill(dp[i], INF));
			dp[0][0] = 0L;
			IntStream.range(0, n).forEach(i -> {
				/** INF以外の dp[i][j-r] ... dp[i][j-l] をすべて格納するためのマップ */
				NavigableMap<Long, Integer> map = new TreeMap<>();
				int k = datas[i].r - datas[i].l + 1;
				System.arraycopy(dp[i], 0, dp[i + 1], 0, w + 1);
				IntStream.range(0, k).forEach(j -> {
					add(map, dp[i][j]);
					if (!map.isEmpty()) {
						dp[i + 1][j + datas[i].l] = Math.max(dp[i][j + datas[i].l], map.lastKey() + datas[i].v);
					}
				});
				IntStream.rangeClosed(datas[i].r, w).forEach(j -> {
					if (!map.isEmpty()) {
						dp[i + 1][j] = Math.max(dp[i][j], map.lastKey() + datas[i].v);
						remove(map, dp[i][j - datas[i].r]);
					}
					add(map, dp[i][j - datas[i].l + 1]);
				});
			});
			System.out.println((INF == dp[n][w]) ? -1 : dp[n][w]);
		}
	}

	/**
	 * マップのvalueのカウントを+1にする
	 *
	 * @param map
	 * @param value
	 */
	private static void add(NavigableMap<Long, Integer> map, long value) {
		if (INF != value) {
			map.put(value, map.getOrDefault(value, 0) + 1);
		}
	}

	/**
	 * マップのvalueのカウントを-1にする
	 *
	 * @param map
	 * @param value
	 */
	private static void remove(NavigableMap<Long, Integer> map, long value) {
		if (INF != value) {
			int count = map.get(value);
			if (1 == count) {
				map.remove(value);
			} else {
				map.put(value, count - 1);
			}
		}
	}

	/**
	 * l,r,v を格納するクラス
	 */
	private static class Data {
		int l, r;
		long v;

		Data(int l, int r, long v) {
			super();
			this.l = l;
			this.r = r;
			this.v = v;
		}
	}
}
