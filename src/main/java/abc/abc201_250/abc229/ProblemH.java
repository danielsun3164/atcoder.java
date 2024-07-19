package abc.abc201_250.abc229;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc229/editorial/2977 の解説の実装<br/>
 * https://atcoder.jp/contests/abc229/submissions/27486399 にも参考
 */
public class ProblemH {

	/** 黒を表す文字 */
	private static final char BLACK = 'B';
	/** 白を表す文字 */
	private static final char WHITE = 'W';
	/** 空を表す文字 */
	private static final char BLANK = '.';
	/** 最大値 */
	private static final long INF = Long.MAX_VALUE >> 1;
	/** 2^10 */
	private static final long KEI = 1L << 10;
	/** 10000 */
	private static final int MAN = 10_000;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			char[][] a = new char[n][n];
			IntStream.range(0, n).forEach(i -> {
				char[] s = scanner.next().toCharArray();
				IntStream.range(0, n).forEach(j -> a[j][i] = s[j]);
			});
			Map<String, Long> map = new HashMap<>();
			long answer = Arrays.stream(a).mapToLong(ai -> calc(ai, map)).sum();
			System.out.println((answer > 0L) ? "Takahashi" : "Snuke");
		}
	}

	/**
	 * 与えられたマスの状態の結果を計算する
	 *
	 * @param s   マスの状態
	 * @param map 計算結果を保存するためのマップ
	 * @return 与えられたマスの状態の結果
	 */
	private static long calc(char[] s, Map<String, Long> map) {
		String key = new String(s);
		if (map.containsKey(key)) {
			return map.get(key);
		}
		long lMax = -INF, rMin = INF;
		int n = s.length;
		{
			for (int i = 0; i < n; i++) {
				if (BLACK == s[i]) {
					s[i] = BLANK;
					lMax = Math.max(lMax, calc(s, map));
					s[i] = BLACK;
				}
			}
			for (int i = 1; i < n; i++) {
				if ((BLANK == s[i - 1]) && (WHITE == s[i])) {
					swap(s, i - 1, i);
					lMax = Math.max(lMax, calc(s, map));
					swap(s, i - 1, i);
				}
			}
		}
		{
			for (int i = 0; i < n; i++) {
				if (WHITE == s[i]) {
					s[i] = BLANK;
					rMin = Math.min(rMin, calc(s, map));
					s[i] = WHITE;
				}
			}
			for (int i = 1; i < n; i++) {
				if ((BLANK == s[i - 1]) && (BLACK == s[i])) {
					swap(s, i - 1, i);
					rMin = Math.min(rMin, calc(s, map));
					swap(s, i - 1, i);
				}
			}
		}
		if ((-INF == lMax) && (INF == rMin)) {
			map.put(key, 0L);
			return 0L;
		}
		if ((-INF == lMax) || (INF == rMin)) {
			for (int z = 0; z <= MAN; z++) {
				long result = z * KEI;
				if ((lMax < result) && (result < rMin)) {
					map.put(key, result);
					return result;
				}
				result *= -1;
				if ((lMax < result) && (result < rMin)) {
					map.put(key, result);
					return result;
				}
			}
		}
		long p = KEI;
		while (p > 0L) {
			for (int z = 0; z <= MAN; z++) {
				long result = z * p;
				if ((result > Math.abs(lMax)) && (result > Math.abs(rMin))) {
					break;
				}
				if ((lMax < result) && (result < rMin)) {
					map.put(key, result);
					return result;
				}
				result *= -1;
				if ((lMax < result) && (result < rMin)) {
					map.put(key, result);
					return result;
				}
			}
			p >>= 1;
		}
		map.put(key, 0L);
		return 0L;
	}

	/**
	 * 配列sのi番目の要素とj番目の要素を交換する
	 *
	 * @param s 配列
	 * @param i
	 * @param j
	 */
	private static void swap(char[] s, int i, int j) {
		char t = s[i];
		s[i] = s[j];
		s[j] = t;
	}
}
