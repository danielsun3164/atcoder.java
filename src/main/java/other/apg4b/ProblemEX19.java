package other.apg4b;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemEX19 {

	private static final int N = 9;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int[][] a = new int[N][N];
			IntStream.range(0, N).forEach(i -> IntStream.range(0, N).forEach(j -> a[i][j] = scanner.nextInt()));
			int correct = 0, wrong = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if ((i + 1) * (j + 1) == a[i][j]) {
						correct++;
					} else {
						wrong++;
						a[i][j] = (i + 1) * (j + 1);
					}
				}
			}
			IntStream.range(0, N).forEach(i -> System.out.println(
					IntStream.range(0, N).mapToObj(j -> String.valueOf(a[i][j])).collect(Collectors.joining(" "))));
			System.out.println(correct);
			System.out.println(wrong);
		}
	}
}
