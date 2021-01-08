package abc.abc101_150.abc105;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			long[] sum = new long[n + 1];
			sum[0] = 0L;
			Map<Long, Long> map = new HashMap<>();
			map.put(0L, 1L);
			IntStream.rangeClosed(1, n).forEach(i -> {
				sum[i] = (sum[i - 1] + scanner.nextLong()) % m;
				map.put(sum[i], map.getOrDefault(sum[i], 0L) + 1L);
			});
			System.out.println(
					map.entrySet().stream().mapToLong(entry -> entry.getValue() * (entry.getValue() - 1) / 2).sum());
		}
	}
}
