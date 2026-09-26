package abc.abc201_250.abc242;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt(), x = scanner.nextInt();
			System.out.println((x <= a) ? 1.0d : ((x <= b) ? c / (double) (b - a) : 0.0d));
		}
	}
}
