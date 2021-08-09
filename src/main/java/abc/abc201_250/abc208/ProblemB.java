package abc.abc201_250.abc208;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	/** 硬貨の種類数 */
	private static final int N = 10;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int[] c = new int[N];
			c[0] = 1;
			IntStream.range(1, N).forEach(i -> c[i] = c[i - 1] * (i + 1));
			int p = scanner.nextInt(), answer = 0;
			for (int i = N - 1; i >= 0; i--) {
				answer += p / c[i];
				p %= c[i];
			}
			System.out.println(answer);
		}
	}
}
