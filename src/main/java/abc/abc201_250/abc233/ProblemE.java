package abc.abc201_250.abc233;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemE {

	/** 10 */
	private static final int TEN = 10;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] x = scanner.next().toCharArray();
			int n = x.length;
			int[] answer = new int[n];
			Arrays.fill(answer, 0);
			IntStream.range(0, n).forEach(i -> answer[i] = x[i] - '0');
			IntStream.range(1, n).forEach(i -> answer[i] += answer[i - 1]);
			IntStream.range(1, n).map(i -> n - i).forEach(i -> {
				answer[i - 1] += answer[i] / TEN;
				answer[i] = answer[i] % TEN;
			});
			Arrays.stream(answer).forEach(System.out::print);
			System.out.println();
		}
	}
}
