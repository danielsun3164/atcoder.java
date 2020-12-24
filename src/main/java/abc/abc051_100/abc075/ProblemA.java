package abc.abc051_100.abc075;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemA {

	/** 入力数字の数 */
	private static final int N = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			Map<Integer, Integer> map = new HashMap<>();
			IntStream.range(0, N).forEach(i -> {
				int a = scanner.nextInt();
				map.put(a, map.getOrDefault(a, 0) + 1);
			});
			System.out
					.println(map.entrySet().stream().filter(entry -> entry.getValue() == 1).findFirst().get().getKey());
		}
	}
}
