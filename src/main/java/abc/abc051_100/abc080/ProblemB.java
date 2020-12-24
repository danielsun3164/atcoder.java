package abc.abc051_100.abc080;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println((0 == (n % f(n)) ? "Yes" : "No"));
		}
	}

	/**
	 * 整数xを十進法で表したときの各桁の数字の和を求める
	 * 
	 * @param x 入力数字
	 * @return 整数xを十進法で表したときの各桁の数字の和
	 */
	private static int f(int x) {
		int result = 0;
		while (x > 0) {
			result += x % 10;
			x /= 10;
		}
		return result;
	}
}
