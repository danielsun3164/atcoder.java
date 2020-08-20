package abc099;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt();
			int n = b - a;
			System.out.println(n * (n - 1) / 2 - a);
		}
	}
}
