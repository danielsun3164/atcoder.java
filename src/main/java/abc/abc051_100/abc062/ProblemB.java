package abc.abc051_100.abc062;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	/** 囲む文字 */
	private static final char BORDER = '#';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt();
			String[] a = IntStream.range(0, h).mapToObj(i -> scanner.next()).toArray(String[]::new);
			char[] border = new char[w + 2];
			Arrays.fill(border, BORDER);
			System.out.println(border);
			IntStream.range(0, h).forEach(i -> System.out.println(BORDER + a[i] + BORDER));
			System.out.println(border);
		}
	}
}
