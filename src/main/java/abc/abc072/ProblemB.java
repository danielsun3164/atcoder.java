package abc.abc072;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			char[] result = new char[(s.length + 1) / 2];
			IntStream.range(0, result.length).forEach(i -> result[i] = s[2 * i]);
			System.out.println(result);
		}
	}
}
