package abc.abc101_150.abc132;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] d = IntStream.range(0, n).map(i -> scanner.nextInt()).sorted().toArray();
			System.out.println(d[n / 2] - d[n / 2 - 1]);
		}
	}
}
