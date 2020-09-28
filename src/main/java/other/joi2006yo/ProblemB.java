package other.joi2006yo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Map<String, String> map = new HashMap<>();
			IntStream.range(0, n).forEach(i -> map.put(scanner.next(), scanner.next()));
			int m = scanner.nextInt();
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, m).forEach(i -> {
				String s = scanner.next();
				sb.append(map.getOrDefault(s, s));
			});
			System.out.println(sb.toString());
		}
	}
}
