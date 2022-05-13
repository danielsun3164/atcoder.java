package abc.abc051_100.abc057;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), a = scanner.nextInt(), b = scanner.nextInt();
			// m_C_nの配列を計算
			long[][] c = calcC(n);
			long[] v = new long[n];
			// 入力数字のそれぞれの個数を計算するマップ
			Map<Long, Integer> map = new HashMap<>();
			IntStream.range(0, n).forEach(i -> {
				v[i] = scanner.nextLong();
				map.put(v[i], map.getOrDefault(v[i], 0) + 1);
			});
			Arrays.sort(v);
			// doubleでは誤差が発生するため、平均値はBigDecimalで計算
			System.out.println(IntStream.rangeClosed(1, a).mapToObj(i -> BigDecimal.valueOf(v[n - i]))
					.reduce(BigDecimal.ZERO, (s, vi) -> s.add(vi))
					.divide(BigDecimal.valueOf(a), 10, RoundingMode.HALF_UP));
			if (v[n - 1] == v[n - a]) {
				Integer count = map.get(v[n - 1]);
				int max = Math.min(count, b);
				System.out.println(IntStream.rangeClosed(a, max).mapToLong(i -> c[count][i]).sum());
			} else {
				long[] keys = map.keySet().stream().sorted((l1, l2) -> l2.compareTo(l1)).mapToLong(Long::longValue)
						.toArray();
				// map.get(i) はソートされたvにiが現れるまでの数字の個数（iより大きい数字の個数）
				Map<Long, Integer> countMap = new HashMap<>();
				int count = 0;
				countMap.put(keys[0], count);
				for (int i = 1; i < keys.length; i++) {
					countMap.put(keys[i], count += map.get(keys[i - 1]));
				}
				System.out.println(c[map.get(v[n - a])][a - countMap.get(v[n - a])]);
			}
		}
	}

	/**
	 * パスカルの三角形を使ってm_C_nを計算
	 *
	 * @param n 整数の最大値
	 * @return m_C_n の配列，c[m][n]はm_C_n
	 */
	private static long[][] calcC(int n) {
		long[][] c = new long[n + 1][n + 1];
		c[0][0] = 1;
		IntStream.rangeClosed(1, n).forEach(i -> IntStream.rangeClosed(0, i).forEach(j -> {
			// c[i][j] = c[i-1][j-1]+c[i-1][j]
			if ((i > 0) && (j > 0)) {
				c[i][j] = c[i - 1][j - 1] + c[i - 1][j];
			} else {
				c[i][j] = 1;
			}
		}));
		return c;
	}
}
