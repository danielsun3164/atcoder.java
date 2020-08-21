package abc102;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println((1 == (n & 1)) ? (n << 1) : n);
		}
	}
}
