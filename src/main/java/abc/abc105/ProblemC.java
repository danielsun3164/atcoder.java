package abc.abc105;

import java.util.Scanner;

public class ProblemC {

	/** 進数のベース */
	private static final int RADIX = -2;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			StringBuilder sb = new StringBuilder((0 == n) ? "0" : "");
			while (Math.abs(n) > 0) {
				int digit = n % RADIX;
				if (digit >= 0) {
					sb.append(digit);
					n /= RADIX;
				} else {
					sb.append(digit - RADIX);
					n = (n + RADIX) / RADIX;
				}
			}
			System.out.println(sb.reverse().toString());
		}
	}
}
