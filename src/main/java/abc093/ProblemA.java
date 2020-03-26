package abc093;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemA {

	private static final int N = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			System.out.println((N == IntStream.range(0, s.length).map(i -> s[i]).distinct().count()) ? "Yes" : "No");
		}
	}
}
