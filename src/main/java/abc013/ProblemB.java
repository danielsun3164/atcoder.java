package abc013;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int max = Math.max(a, b);
			int min = Math.min(a, b);
			System.out.println(Math.min(max - min, min + 10 - max));
		}
	}
}
