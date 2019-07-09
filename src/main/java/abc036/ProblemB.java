package abc036;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			char[][] s = new char[n][n];
			IntStream.range(0, n).forEach(i -> s[i] = scanner.next().toCharArray());
			char[][] t = new char[n][n];
			IntStream.range(0, n).forEach(i -> IntStream.range(0, n).forEach(j -> t[i][j] = s[n - j - 1][i]));
			IntStream.range(0, n).forEach(i -> System.out.println(t[i]));
		}
	}
}
