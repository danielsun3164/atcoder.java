package abc.abc101_150.abc125;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] v = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int[] c = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			System.out.println(IntStream.range(0, n).map(i -> v[i] - c[i]).filter(i -> i > 0).sum());
		}
	}
}
