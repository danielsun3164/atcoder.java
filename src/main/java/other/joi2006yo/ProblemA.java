package other.joi2006yo;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int a = 0, b = 0;
			for (int i = 0; i < n; i++) {
				int x = scanner.nextInt(), y = scanner.nextInt();
				if (x > y) {
					a += x + y;
				} else if (y > x) {
					b += x + y;
				} else {
					a += x;
					b += y;
				}
			}
			System.out.println(a + " " + b);
		}
	}
}
