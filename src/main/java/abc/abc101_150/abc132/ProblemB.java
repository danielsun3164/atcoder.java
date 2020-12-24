package abc.abc101_150.abc132;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] p = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			System.out.println(IntStream.range(1, n - 1)
					.filter(i -> ((p[i] > p[i - 1]) && (p[i] < p[i + 1])) || ((p[i] > p[i + 1]) && (p[i] < p[i - 1])))
					.count());
		}
	}
}
