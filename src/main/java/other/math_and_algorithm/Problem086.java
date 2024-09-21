package other.math_and_algorithm;

import java.util.Scanner;

public class Problem086 {

	/** カッコの始まり */
	private static final char START = '(';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			char[] s = scanner.next().toCharArray();
			int sum = 0;
			for (int i = 0; i < n; i++) {
				if (START == s[i]) {
					sum++;
				} else {
					sum--;
				}
				if (sum < 0) {
					System.out.println("No");
					return;
				}
			}
			System.out.println((0 == sum) ? "Yes" : "No");
		}
	}
}
