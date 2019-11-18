package abc070;

import static java.lang.Math.*;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int c = scanner.nextInt();
			int d = scanner.nextInt();
			System.out.println(max(min(b, d) - max(a, c), 0));
		}
	}
}
