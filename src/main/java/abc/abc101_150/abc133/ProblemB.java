package abc.abc101_150.abc133;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), d = scanner.nextInt();
			int[][] x = new int[n][d];
			IntStream.range(0, n).forEach(i -> IntStream.range(0, d).forEach(j -> x[i][j] = scanner.nextInt()));
			// 平方のセット
			Set<Integer> set = IntStream.rangeClosed(0, 200).map(i -> i * i).boxed().collect(Collectors.toSet());
			System.out.println(IntStream.range(0, n - 1)
					.map(i -> (int) IntStream.range(i + 1, n).filter(j -> set.contains(
							IntStream.range(0, x[i].length).map(k -> (x[i][k] - x[j][k]) * (x[i][k] - x[j][k])).sum()))
							.count())
					.sum());
		}
	}
}
