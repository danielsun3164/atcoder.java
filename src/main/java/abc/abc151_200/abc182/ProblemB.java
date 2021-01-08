package abc.abc151_200.abc182;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			// a_iの2以上の約数とその数を保存するマップ
			Map<Integer, Integer> map = new HashMap<>();
			IntStream.range(0, n).forEach(i -> {
				int ai = scanner.nextInt();
				map.put(ai, map.getOrDefault(ai, 0) + 1);
				for (int j = 2; j * j <= ai; j++) {
					if (0 == (ai % j)) {
						map.put(j, map.getOrDefault(j, 0) + 1);
						if ((ai / j) != j) {
							map.put(ai / j, map.getOrDefault(ai / j, 0) + 1);
						}
					}
				}
			});
			System.out.println(map.entrySet().stream().max((a, b) -> {
				if (a.getValue().equals(b.getValue())) {
					return a.getKey().compareTo(b.getKey());
				} else {
					return a.getValue().compareTo(b.getValue());
				}
			}).get().getKey());
		}
	}
}
