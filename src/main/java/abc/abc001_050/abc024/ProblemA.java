package abc.abc001_050.abc024;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt(), k = scanner.nextInt();
			int s = scanner.nextInt(), t = scanner.nextInt();
			if ((s + t) >= k) {
				System.out.println((a - c) * s + (b - c) * t);
			} else {
				System.out.println(a * s + b * t);
			}
		}
	}
}
