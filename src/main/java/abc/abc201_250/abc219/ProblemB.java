package abc.abc201_250.abc219;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemB {

	/** Sの数 */
	private static final int N = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String[] s = IntStream.range(0, N).mapToObj(i -> scanner.next()).toArray(String[]::new);
			char[] t = scanner.next().toCharArray();
			System.out.println(IntStream.range(0, t.length).mapToObj(i -> s[t[i] - '1']).collect(Collectors.joining()));
		}
	}
}
