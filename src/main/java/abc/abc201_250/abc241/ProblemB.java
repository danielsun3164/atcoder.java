package abc.abc201_250.abc241;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			Map<Integer, Integer> map = new HashMap<>();
			IntStream.range(0, n).forEach(i -> {
				int a = scanner.nextInt();
				map.put(a, map.getOrDefault(a, 0) + 1);
			});
			for (int i = 0; i < m; i++) {
				int b = scanner.nextInt();
				if (map.containsKey(b)) {
					if (map.get(b).intValue() == 1) {
						map.remove(b);
					} else {
						map.put(b, map.get(b) - 1);
					}
				} else {
					System.out.println("No");
					return;
				}
			}
			System.out.println("Yes");
		}
	}
}
