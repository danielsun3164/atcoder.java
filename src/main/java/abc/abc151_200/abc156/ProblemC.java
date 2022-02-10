package abc.abc151_200.abc156;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] x = new int[n];
			int average = IntStream.range(0, n).map(i -> x[i] = scanner.nextInt()).sum() / n;
			System.out.println(IntStream.rangeClosed(average - 1, average + 1)
					.map(avg -> IntStream.range(0, n).map(i -> (x[i] - avg) * (x[i] - avg)).sum()).min().getAsInt());
		}
	}
}
