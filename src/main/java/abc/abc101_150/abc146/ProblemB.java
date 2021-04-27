package abc.abc101_150.abc146;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Map<Character, Character> map = new HashMap<>();
			for (char a = 'A'; a <= 'Z'; a++) {
				map.put(a, (char) ((a - 'A' + n) % 26 + 'A'));
			}
			char[] s = scanner.next().toCharArray();
			char[] result = new char[s.length];
			IntStream.range(0, s.length).forEach(i -> result[i] = map.get(s[i]));
			System.out.println(result);
		}
	}
}
