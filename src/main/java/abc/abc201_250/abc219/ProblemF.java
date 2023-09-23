package abc.abc201_250.abc219;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc219/submissions/33503432 にも参考
 */
public class ProblemF {

	/** X座標の差分 */
	private static final int[] XS = { -1, 1, 0, 0 };
	/** Y座標の差分 */
	private static final int[] YS = { 0, 0, -1, 1 };
	/** LRUDの文字と座標差分とのマップ */
	private static final Map<Character, Integer> MAP = Map.of('L', 0, 'R', 1, 'U', 2, 'D', 3);
	/** intのサイズ */
	private static final int N = Integer.SIZE;
	/** 繰り返し計算する回数の最大値 */
	private static final int M = 200_000;
	/** MASK */
	private static final long MASK = (1L << N) - 1L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			long k = scanner.nextLong();
			Set<Long> set = new TreeSet<>();
			long nx = 0L, ny = 0L;
			set.add(0L);
			for (char c : s) {
				nx += XS[MAP.get(c)];
				ny += YS[MAP.get(c)];
				set.add((nx << N) | (ny & MASK));
			}
			if (((0L == nx) && (0L == ny)) || (1L == k)) {
				System.out.println(set.size());
				return;
			}
			if (0L == nx) {
				Set<Long> set2 = new TreeSet<>();
				for (long p : set) {
					long x = (int) ((p >> N) & MASK), y = (int) (p & MASK);
					set2.add((y << N) | (x & MASK));
				}
				nx = ny;
				ny = 0L;
				set = set2;
			}
			Map<Long, List<Long>> map = new HashMap<>();
			for (long p : set) {
				long x = (int) ((p >> N) & MASK), y = (int) (p & MASK), q = divide(x, nx);
				long rx = x - q * nx, ry = y - q * ny, key = (rx << N) | (ry & MASK);
				if (!map.containsKey(key)) {
					map.put(key, new ArrayList<>());
				}
				map.get(key).add(q);
			}
			long[] answer = new long[M + 1];
			Arrays.fill(answer, 0L);
			for (Entry<Long, List<Long>> entry : map.entrySet()) {
				List<Long> list = entry.getValue();
				Collections.sort(list);
				IntStream.range(0, list.size() - 1).forEach(i -> {
					answer[1]++;
					answer[(int) (list.get(i + 1) - list.get(i) + 1)]--;
				});
				answer[1]++;
			}
			IntStream.rangeClosed(1, M).forEach(i -> answer[i] += answer[i - 1]);
			IntStream.rangeClosed(1, M).forEach(i -> answer[i] += answer[i - 1]);
			System.out.println((k <= M) ? answer[(int) k] : (answer[M] + (k - M) * map.size()));
		}
	}

	/**
	 * a/b を計算する
	 *
	 * @param a
	 * @param b
	 * @return a/b
	 */
	private static long divide(long a, long b) {
		if (b < 0) {
			a = -a;
			b = -b;
		}
		return (a >= 0) ? a / b : -(((-a) + (b - 1)) / b);
	}
}
