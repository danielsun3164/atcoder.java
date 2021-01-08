package abc.abc151_200.abc179;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[][] d = new int[n][2];
			IntStream.range(0, n).forEach(i -> {
				d[i][0] = scanner.nextInt();
				d[i][1] = scanner.nextInt();
			});
			for (int i = 0; i < n - 2; i++) {
				if ((d[i][0] == d[i][1]) && (d[i + 1][0] == d[i + 1][1]) && (d[i + 2][0] == d[i + 2][1])) {
					System.out.println("Yes");
					return;
				}
			}
			System.out.println("No");
		}
	}
}
