package abc.abc201_250.abc212;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt();
			System.out.println((0 == b) ? "Gold" : ((0 == a) ? "Silver" : "Alloy"));
		}
	}
}
