package abc.abc026;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] r = IntStream.range(0, n).map(i -> scanner.nextInt()).sorted().toArray();
			int minus = 1, sum = 0;
			for (int i = n - 1; i >= 0; i--) {
				sum += minus * r[i] * r[i];
				minus *= -1;
			}
			System.out.println(sum * Math.PI);
		}
	}
}
