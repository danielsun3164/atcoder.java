package abc.abc201_250.abc233;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long k = scanner.nextLong(), sum = 0L, answer = 0L;
			Map<Long, Long> map = new HashMap<>();
			map.put(sum, map.getOrDefault(sum, 0L) + 1);
			for (int i = 0; i < n; i++) {
				sum += scanner.nextLong();
				answer += map.getOrDefault(sum - k, 0L);
				map.put(sum, map.getOrDefault(sum, 0L) + 1);
			}
			System.out.println(answer);
		}
	}
}
