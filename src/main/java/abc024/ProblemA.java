package abc024;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int c = scanner.nextInt();
			int k = scanner.nextInt();
			int s = scanner.nextInt();
			int t = scanner.nextInt();
			if ((s + t) >= k) {
				System.out.println((a - c) * s + (b - c) * t);
			} else {
				System.out.println(a * s + b * t);
			}
		}
	}
}