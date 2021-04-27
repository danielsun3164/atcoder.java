package abc.abc101_150.abc146;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			// sum[i]は(a[1]+...+a[i]-i) mod k
			long[] sum = new long[n + 1];
			sum[0] = 0L;
			IntStream.rangeClosed(1, n).forEach(i -> sum[i] = safeMod((scanner.nextLong() + sum[i - 1]) - 1, k));
			Map<Long, Long> map = new HashMap<>();
			System.out.println(IntStream.rangeClosed(0, n).mapToLong(i -> {
				long value = map.getOrDefault(sum[i], 0L);
				map.put(sum[i], value + 1L);
				if (i >= (k - 1)) {
					map.put(sum[(i - k) + 1], map.get(sum[(i - k) + 1]) - 1L);
				}
				return value;
			}).sum());
		}
	}

	/**
	 * n mod k を計算する
	 *
	 * @param n
	 * @param k
	 * @return n mod k
	 */
	private static long safeMod(long n, long k) {
		long r = n % k;
		if (r < 0) {
			r += k;
		}
		return r;
	}
}
