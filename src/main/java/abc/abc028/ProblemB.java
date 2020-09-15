package abc.abc028;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemB {

	/** 文字の種類数 */
	private static final int N = 6;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			int[] result = new int[N];
			Arrays.fill(result, 0);
			IntStream.range(0, s.length).forEach(i -> result[s[i] - 'A']++);
			System.out.println(Arrays.stream(result).mapToObj(i -> String.valueOf(i)).collect(Collectors.joining(" ")));
		}
	}
}
