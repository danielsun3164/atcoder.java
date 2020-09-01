package other.apg4b;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemEX18 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			char[][] s = new char[n][n];
			IntStream.range(0, n).forEach(i -> Arrays.fill(s[i], '-'));
			IntStream.range(0, m).forEach(i -> {
				int winner = scanner.nextInt() - 1;
				int loser = scanner.nextInt() - 1;
				s[winner][loser] = 'o';
				s[loser][winner] = 'x';
			});
			IntStream.range(0, n).forEach(i -> System.out.println(
					IntStream.range(0, n).mapToObj(j -> String.valueOf(s[i][j])).collect(Collectors.joining(" "))));
		}
	}
}
