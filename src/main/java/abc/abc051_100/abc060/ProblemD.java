package abc.abc051_100.abc060;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long maxW = scanner.nextLong();
			long[] w = new long[n], v = new long[n];
			IntStream.range(0, n).forEach(i -> {
				w[i] = scanner.nextLong();
				v[i] = scanner.nextLong();
			});
			System.out.println(getResult(0, 0L, maxW, w, v, new HashMap<>()));
		}
	}

	/**
	 * @param nowIndex 現在の計算対象Index
	 * @param nowW     現在選んだ物の重さ合計
	 * @param maxW     最大重さ
	 * @param w        重さの配列
	 * @param v        価値の配列
	 * @param map      計算結果を保存するマップ
	 * @return 現在の計算対象とすでに選んだ物の重さをもとに、得られる最大の価値
	 */
	private static long getResult(int nowIndex, long nowW, final long maxW, final long[] w, final long[] v,
			Map<List<Long>, Long> map) {
		int n = w.length;
		if (nowIndex >= n) {
			return 0L;
		}
		List<Long> key = Arrays.asList((long) nowIndex, nowW);
		Long result = map.get(key);
		if (null == result) {
			if (nowW + w[nowIndex] <= maxW) {
				result = Math.max(getResult(nowIndex + 1, nowW + w[nowIndex], maxW, w, v, map) + v[nowIndex],
						getResult(nowIndex + 1, nowW, maxW, w, v, map));
			} else {
				result = getResult(nowIndex + 1, nowW, maxW, w, v, map);
			}
			map.put(key, result);
		}

		return result;
	}
}
