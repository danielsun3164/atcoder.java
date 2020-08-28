package abc107;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			int[] x = new int[n];
			IntStream.range(0, n).forEach(i -> x[i] = scanner.nextInt());
			System.out.println(IntStream.range(0, n - k + 1).map(i -> {
				// 解説通りの計算式
				return Math.min(Math.abs(x[i]), Math.abs(x[i + k - 1])) + Math.abs(x[i + k - 1] - x[i]);
			}).min().getAsInt());
		}
	}
}
