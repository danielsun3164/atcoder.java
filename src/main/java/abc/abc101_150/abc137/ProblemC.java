package abc.abc101_150.abc137;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Map<String, Integer> map = new HashMap<>();
			System.out.println(IntStream.range(0, n).mapToLong(i -> {
				char[] s = scanner.next().toCharArray();
				Arrays.sort(s);
				String key = String.valueOf(s);
				int value = map.getOrDefault(key, 0);
				map.put(key, value + 1);
				return value;
			}).sum());
		}
	}
}
