package abc062;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	private static final char BORDER = '#';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt();
			int w = scanner.nextInt();
			String[] a = new String[h];
			IntStream.range(0, h).forEach(i -> a[i] = scanner.next());
			char[] border = new char[w + 2];
			Arrays.fill(border, BORDER);
			System.out.println(border);
			IntStream.range(0, h).forEach(i -> System.out.println(BORDER + a[i] + BORDER));
			System.out.println(border);
		}
	}
}
