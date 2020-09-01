package abc.abc100;

import java.util.Scanner;

public class ProblemB {

	/** 100 */
	private static final int HUNDRED = 100;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int d = scanner.nextInt(), n = scanner.nextInt();
			int pow = 1;
			for (int i = 0; i < d; i++) {
				pow *= HUNDRED;
			}
			// 解説どおりの式で計算
			System.out.println((n + (n - 1) / (HUNDRED - 1)) * pow);
		}
	}
}
