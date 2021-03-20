package other.joi2008yo;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	/** Jの文字 */
	private static final char J = 'J';
	/** Oの文字 */
	private static final char O = 'O';
	/** Iの文字 */
	private static final char I = 'I';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			System.out.println(IntStream.range(0, s.length - 2)
					.filter(i -> (J == s[i]) && (O == s[i + 1]) && (I == s[i + 2])).count());
			System.out.println(IntStream.range(0, s.length - 2)
					.filter(i -> (I == s[i]) && (O == s[i + 1]) && (I == s[i + 2])).count());
		}
	}
}
