package abc.abc008;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			scanner.nextLine();
			Map<String, Integer> map = new HashMap<>();
			IntStream.range(0, n).forEach(i -> {
				String s = scanner.nextLine();
				Integer integer = map.getOrDefault(s, 0);
				map.put(s, integer + 1);
			});
			System.out.println(
					map.entrySet().stream().max((x, y) -> x.getValue().compareTo(y.getValue())).get().getKey());
		}
	}
}
