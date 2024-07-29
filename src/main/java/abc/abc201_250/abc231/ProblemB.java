package abc.abc201_250.abc231;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Map<String, Integer> map = new HashMap<>();
			IntStream.range(0, n).forEach(i -> {
				String s = scanner.next();
				map.put(s, map.getOrDefault(s, 0) + 1);
			});
			String answer = "";
			int max = 0;
			for (Entry<String, Integer> entry : map.entrySet()) {
				if (entry.getValue() > max) {
					max = entry.getValue();
					answer = entry.getKey();
				}
			}
			System.out.println(answer);
		}
	}
}
