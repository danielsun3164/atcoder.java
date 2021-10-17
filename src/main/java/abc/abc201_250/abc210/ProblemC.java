package abc.abc201_250.abc210;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			int[] c = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			Map<Integer, Integer> map = new HashMap<>();
			IntStream.range(0, k).forEach(i -> map.put(c[i], map.getOrDefault(c[i], 0) + 1));
			int answer = map.size();
			for (int i = 0; i < n - k; i++) {
				map.put(c[i + k], map.getOrDefault(c[i + k], 0) + 1);
				int value = map.get(c[i]);
				if (1 == value) {
					map.remove(c[i]);
				} else {
					map.put(c[i], value - 1);
				}
				answer = Math.max(answer, map.size());
			}
			System.out.println(answer);
		}
	}
}
