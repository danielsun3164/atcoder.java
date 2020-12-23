package abc.abc186;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println(IntStream.rangeClosed(1, n).filter(i -> ok(i, 10) && ok(i, 8)).count());
		}
	}

	private static boolean ok(int n, int base) {
		while (n > 0) {
			int r = n % base;
			if (7 == r) {
				return false;
			}
			n /= base;
		}
		return true;
	}
}
