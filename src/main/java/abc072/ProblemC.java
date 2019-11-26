package abc072;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			// 生成可能の数字と数のマップ
			Map<Integer, Integer> map = new HashMap<>();
			IntStream.range(0, n).forEach(i -> {
				int number = scanner.nextInt();
				map.put(number - 1, map.getOrDefault(number - 1, 0) + 1);
				map.put(number, map.getOrDefault(number, 0) + 1);
				map.put(number + 1, map.getOrDefault(number + 1, 0) + 1);
			});
			System.out.println(
					map.entrySet().stream().max((x, y) -> x.getValue().compareTo(y.getValue())).get().getValue());
		}
	}
}
