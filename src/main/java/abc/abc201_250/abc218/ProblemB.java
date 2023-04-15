package abc.abc201_250.abc218;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	/** 入力整数数 */
	private static final int N = 26;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = new char[N];
			IntStream.range(0, N).forEach(i -> s[i] = (char) (scanner.nextInt() - 1 + 'a'));
			System.out.println(s);
		}
	}
}
