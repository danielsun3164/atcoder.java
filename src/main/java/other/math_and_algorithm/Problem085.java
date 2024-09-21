package other.math_and_algorithm;

import java.util.Scanner;

public class Problem085 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), x = scanner.nextInt(), y = scanner.nextInt();
			for (int a = 1; a <= n; a++) {
				if (0 == y % a) {
					int xa = x - a, ya = y / a;
					for (int b = a; b <= n; b++) {
						if (0 == ya % b) {
							int xab = xa - b, yab = ya / b;
							for (int c = b; c <= n; c++) {
								if ((0 == yab % c) && (xab == c + yab / c) && (yab / c <= n)) {
									System.out.println("Yes");
									return;
								}
							}
						}
					}
				}
			}
			System.out.println("No");
		}
	}
}
