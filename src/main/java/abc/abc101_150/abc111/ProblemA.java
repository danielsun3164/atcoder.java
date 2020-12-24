package abc.abc101_150.abc111;

import java.util.Scanner;

public class ProblemA {

	/** 数字の和 */
	private static final int SUM = 999 + 111;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println(SUM - n);
		}
	}
}
