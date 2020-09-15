package abc.abc049;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt();
			char[][] input = new char[h][];
			IntStream.range(0, h).forEach(i -> input[i] = scanner.next().toCharArray());
			char[][] output = new char[2 * h][w];
			IntStream.range(0, 2 * h).forEach(i -> IntStream.range(0, w).forEach(j -> output[i][j] = input[i / 2][j]));
			IntStream.range(0, 2 * h).forEach(i -> System.out.println(output[i]));
		}
	}
}
