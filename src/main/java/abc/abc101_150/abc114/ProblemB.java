package abc.abc101_150.abc114;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	/** 基準となる数字 */
	private static final int N = 753;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			System.out.println(IntStream.range(0, s.length - 2)
					.map(i -> (s[i] - '0') * 100 + (s[i + 1] - '0') * 10 + (s[i + 2] - '0')).map(n -> Math.abs(n - N))
					.min().getAsInt());
		}
	}
}
