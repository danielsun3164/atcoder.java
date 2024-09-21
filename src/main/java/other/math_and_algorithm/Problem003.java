package other.math_and_algorithm;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem003 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println(IntStream.range(0, n).map(i -> scanner.nextInt()).sum());
		}
	}
}
