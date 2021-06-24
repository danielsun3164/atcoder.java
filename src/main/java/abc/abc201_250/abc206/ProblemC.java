package abc.abc201_250.abc206;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Map<Integer, Integer> map = new HashMap<>();
			IntStream.range(0, n).forEach(i -> {
				int a = scanner.nextInt();
				map.put(a, map.getOrDefault(a, 0) + 1);
			});
			long ans = (n * (long) (n - 1)) / 2;
			for (Entry<Integer, Integer> entry : map.entrySet()) {
				ans -= c(entry.getValue(), 2);
			}
			System.out.println(ans);
		}
	}

	/**
	 * n_C_m を計算する
	 *
	 * @param n
	 * @param m
	 * @return n_C_m
	 */
	private static long c(int n, int m) {
		long result = 1L;
		for (int i = 1; i <= m; i++) {
			result *= (n + 1) - i;
			result /= i;
		}
		return result;
	}
}
