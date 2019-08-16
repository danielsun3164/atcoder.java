package abc047;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	private static final int WHITE = 1;
	private static final int BLACK = 0;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int w = scanner.nextInt();
			int h = scanner.nextInt();
			int[][] cells = new int[w][h];
			IntStream.range(0, w).forEach(i -> Arrays.fill(cells[i], WHITE));
			int n = scanner.nextInt();
			IntStream.range(0, n).forEach(i -> {
				int x = scanner.nextInt() - 1;
				int y = scanner.nextInt() - 1;
				int a = scanner.nextInt();
				switch (a) {
				case 1:
					IntStream.rangeClosed(0, x).forEach(j -> Arrays.fill(cells[j], BLACK));
					break;
				case 2:
					IntStream.range(x + 1, w).forEach(j -> Arrays.fill(cells[j], BLACK));
					break;
				case 3:
					IntStream.rangeClosed(0, y).forEach(j -> IntStream.range(0, w).forEach(k -> cells[k][j] = BLACK));
					break;
				case 4:
				default:
					IntStream.range(y + 1, h).forEach(j -> IntStream.range(0, w).forEach(k -> cells[k][j] = BLACK));
					break;
				}
			});
			System.out.println(IntStream.range(0, w).map(i -> Arrays.stream(cells[i]).sum()).sum());
		}
	}
}
