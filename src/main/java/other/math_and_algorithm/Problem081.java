package other.math_and_algorithm;

import java.util.Scanner;

public class Problem081 {

	/** 使用する札の一覧 */
	private static final int[] BILLS = { 10_000, 5_000, 1_000 };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), answer = 0;
			for (int b : BILLS) {
				answer += n / b;
				n %= b;
			}
			System.out.println(answer);
		}
	}
}
