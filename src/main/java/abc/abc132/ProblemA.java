package abc.abc132;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.nextLine().toCharArray();
			Map<Character, Integer> map = new HashMap<>();
			IntStream.range(0, s.length).forEach(i -> map.put(s[i], map.getOrDefault(s[i], 0) + 1));
			if (2 == map.size()) {
				for (Integer value : map.values()) {
					if (!value.equals(2)) {
						System.out.println("No");
						return;
					}
				}
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
	}
}
