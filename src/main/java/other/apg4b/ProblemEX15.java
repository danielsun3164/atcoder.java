package other.apg4b;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemEX15 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int sumA = IntStream.range(0, n).map(i -> scanner.nextInt()).sum();
			int sumB = IntStream.range(0, n).map(i -> scanner.nextInt()).sum();
			int sumC = IntStream.range(0, n).map(i -> scanner.nextInt()).sum();
			System.out.println(sumA * sumB * sumC);
		}
	}
}
