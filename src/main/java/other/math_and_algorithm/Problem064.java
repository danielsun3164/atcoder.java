package other.math_and_algorithm;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem064 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			int sum = IntStream.range(0, n).map(i -> Math.abs(scanner.nextInt())).sum();
			System.out.println((k >= sum) && (0 == (1 & (k - sum))) ? "Yes" : "No");
		}
	}
}
