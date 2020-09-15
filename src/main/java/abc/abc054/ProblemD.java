package abc.abc054;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説を参考に作成したソースコード
 */
public class ProblemD {

	/** 大きい値の定義 */
	private static final int INF = Integer.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), ma = scanner.nextInt(), mb = scanner.nextInt();
			int[] a = new int[n], b = new int[n], c = new int[n];
			IntStream.range(0, n).forEach(i -> {
				a[i] = scanner.nextInt();
				b[i] = scanner.nextInt();
				c[i] = scanner.nextInt();
			});
			int result = getResult(n, ma, mb, 0, 0, 0, a, b, c, new HashMap<>());
			System.out.println((result < INF) ? result : -1);
		}
	}

	/**
	 * @param n
	 * @param ma
	 * @param mb
	 * @param now  現在計算しているindex
	 * @param nowA いままで使ったAの合計
	 * @param nowB いままで使ったBの合計
	 * @param a
	 * @param b
	 * @param c
	 * @param map  既に計算した結果を保存するマップ
	 * @return 計算結果
	 */
	private static int getResult(final int n, final int ma, final int mb, int now, int nowA, int nowB, final int[] a,
			final int[] b, final int[] c, final Map<List<Integer>, Integer> map) {
		if (now >= n) {
			return ((nowA > 0) && (nowB > 0) && (nowA * mb == nowB * ma)) ? 0 : INF;
		}
		List<Integer> key = Arrays.asList(now, nowA, nowB);
		Integer result = map.get(key);
		if (null == result) {
			result = Math.min(getResult(n, ma, mb, now + 1, nowA, nowB, a, b, c, map),
					getResult(n, ma, mb, now + 1, nowA + a[now], nowB + b[now], a, b, c, map) + c[now]);
			map.put(key, result);
		}
		return result;
	}
}
