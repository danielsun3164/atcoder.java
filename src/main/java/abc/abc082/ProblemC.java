package abc.abc082;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Map<Integer, Integer> countMap = new HashMap<>();
			IntStream.range(0, n).forEach(i -> {
				int number = scanner.nextInt();
				countMap.put(number, countMap.getOrDefault(number, 0) + 1);
			});
			System.out.println(countMap.entrySet().stream()
					.mapToInt(entry -> (entry.getValue() >= entry.getKey()) ? entry.getValue() - entry.getKey()
							: entry.getValue())
					.sum());
		}
	}
}
