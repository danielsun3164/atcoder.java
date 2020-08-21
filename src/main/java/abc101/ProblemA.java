package abc101;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemA {

	/** +の符号 */
	private static final char PLUS = '+';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			int plus = (int) IntStream.range(0, s.length).filter(i -> s[i] == PLUS).count();
			System.out.println(plus - (s.length - plus));
		}
	}
}
