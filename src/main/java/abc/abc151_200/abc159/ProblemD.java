package abc.abc151_200.abc159;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = new int[n];
			Map<Integer, Integer> map = new HashMap<>();
			IntStream.range(0, n).forEach(i -> {
				a[i] = scanner.nextInt();
				map.put(a[i], map.getOrDefault(a[i], 0) + 1);
			});
			long sum = map.entrySet().stream().mapToLong(entry -> c(entry.getValue(), 2)).sum();
			// TLE対策として結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			Arrays.stream(a).forEach(ai -> sb.append(sum - map.get(ai) + 1).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * n C m を計算する
	 *
	 * @param n
	 * @param m
	 * @return n C m
	 */
	private static long c(int n, int m) {
		if (m <= n) {
			long answer = 1L;
			for (int i = 1; i <= m; i++) {
				answer *= n + 1 - i;
				answer /= i;
			}
			return answer;
		}
		return 0L;
	}
}
