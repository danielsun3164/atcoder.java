package abc034;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println(((n & 1) == 1) ? n + 1 : n - 1);
		}
	}
}
