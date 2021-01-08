package abc.abc001_050.abc016;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int m = scanner.nextInt(), d = scanner.nextInt();
			System.out.println((0 == (m % d)) ? "YES" : "NO");
		}
	}
}
