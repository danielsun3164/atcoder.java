package abc.abc101_150.abc136;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), r;
			if (n > 99999) {
				r = 90909;
			} else if (n > 9999) {
				r = n - 9999 + 909;
			} else if (n > 999) {
				r = 909;
			} else if (n > 99) {
				r = n - 99 + 9;
			} else if (n > 9) {
				r = 9;
			} else {
				r = n;
			}
			System.out.println(r);
		}
	}
}
