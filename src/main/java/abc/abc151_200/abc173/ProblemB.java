package abc.abc151_200.abc173;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	/** マップのキーの一覧 */
	private static final List<String> KEYS = Arrays.asList("AC", "WA", "TLE", "RE");

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Map<String, Integer> map = new HashMap<>();
			IntStream.range(0, n).forEach(i -> {
				String s = scanner.next();
				map.put(s, map.getOrDefault(s, 0) + 1);
			});
			KEYS.stream().forEach(key -> System.out.println(key + " x " + map.getOrDefault(key, 0)));
		}
	}
}
