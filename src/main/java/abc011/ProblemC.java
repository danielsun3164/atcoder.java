package abc011;

import java.util.Scanner;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int ng1 = scanner.nextInt();
			int ng2 = scanner.nextInt();
			int ng3 = scanner.nextInt();
			if ((ng1 != n) && (ng2 != n) && (ng3 != n)) {
				for (int i = 0; i < 100; i++) {
					if ((ng1 != n - 3) && (ng2 != n - 3) && (ng3 != n - 3)) {
						n -= 3;
					} else if ((ng1 != n - 2) && (ng2 != n - 2) && (ng3 != n - 2)) {
						n -= 2;
					} else if ((ng1 != n - 1) && (ng2 != n - 1) && (ng3 != n - 1)) {
						n -= 1;
					} else {
						break;
					}
				}
			}
			System.out.println((n > 0) ? "NO" : "YES");
		}
	}
}
