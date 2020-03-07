package abc083;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int c = scanner.nextInt();
			int d = scanner.nextInt();
			int left = a + b, right = c + d;
			System.out.println((left == right) ? "Balanced" : (left > right) ? "Left" : "Right");
		}
	}
}
