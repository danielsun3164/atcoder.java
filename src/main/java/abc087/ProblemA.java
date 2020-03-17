package abc087;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int x = scanner.nextInt();
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			System.out.println((x - a) % b);
		}
	}
}
