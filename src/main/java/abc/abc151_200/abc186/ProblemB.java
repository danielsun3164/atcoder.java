package abc.abc151_200.abc186;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt();
			int[][] a = new int[h][w];
			int min = IntStream.range(0, h)
					.map(i -> IntStream.range(0, w).map(j -> a[i][j] = scanner.nextInt()).min().getAsInt()).min()
					.getAsInt();
			System.out
					.println(IntStream.range(0, h).map(i -> IntStream.range(0, w).map(j -> a[i][j] - min).sum()).sum());
		}
	}
}
