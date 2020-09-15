package abc.abc044;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] w = scanner.next().toCharArray();
			Map<Character, Integer> map = new HashMap<>();
			for (char c : w) {
				map.put(c, map.getOrDefault(c, 0) + 1);
			}
			boolean result = true;
			for (Character c : map.keySet()) {
				if (0 != (map.get(c) & 1)) {
					result = false;
					break;
				}
			}
			System.out.println(result ? "Yes" : "No");
		}
	}
}
