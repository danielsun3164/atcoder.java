package other.math_and_algorithm;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem008 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), s = scanner.nextInt();
			System.out.println(IntStream.rangeClosed(1, n).map(i -> Math.max(0, Math.min(n, s - i))).sum());
		}
	}
}
