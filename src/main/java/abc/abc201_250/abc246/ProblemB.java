package abc.abc201_250.abc246;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			double a = scanner.nextDouble(), b = scanner.nextDouble();
			double r = Math.hypot(a, b);
			System.out.println(a / r + " " + b / r);
		}
	}
}
