package abc.abc051_100.abc070;

import static java.lang.Math.max;
import static java.lang.Math.min;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt(), d = scanner.nextInt();
			System.out.println(max(min(b, d) - max(a, c), 0));
		}
	}
}
