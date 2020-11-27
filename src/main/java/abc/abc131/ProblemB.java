package abc.abc131;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), l = scanner.nextInt();
			int sum = (l + l + n - 1) * n / 2, eated = 0;
			if (l < 0 && l + n - 1 > 0) {
				eated = 0;
			} else if (l >= 0) {
				eated = l;
			} else if (l + n - 1 <= 0) {
				eated = l + n - 1;
			}
			System.out.println(sum - eated);
		}
	}
}
