package abc091;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Map<String, Integer> blueMap = new HashMap<>();
			IntStream.range(0, n).forEach(i -> {
				String s = scanner.next();
				blueMap.put(s, blueMap.getOrDefault(s, 0) + 1);
			});
			int m = scanner.nextInt();
			Map<String, Integer> redMap = new HashMap<>();
			IntStream.range(0, m).forEach(i -> {
				String t = scanner.next();
				redMap.put(t, redMap.getOrDefault(t, 0) + 1);
			});
			System.out.println(Math.max(blueMap.entrySet().stream()
					.mapToInt(entry -> entry.getValue() - redMap.getOrDefault(entry.getKey(), 0)).max().getAsInt(), 0));
		}
	}
}
