package abc.abc201_250.abc206;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説の方針2の実装
 */
public class ProblemC別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Map<Integer, Integer> map = new HashMap<>();
			IntStream.range(0, n).forEach(i -> {
				int a = scanner.nextInt();
				map.put(a, map.getOrDefault(a, 0) + 1);
			});
			System.out.println(map.values().stream().mapToLong(value -> (n - value) * (long) value).sum() >> 1);
		}
	}
}
