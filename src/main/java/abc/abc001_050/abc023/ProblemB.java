package abc.abc001_050.abc023;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			String s = scanner.next();
			// nが偶数のときは-1となる、奇数のときは手順(n-1)/2の結果と比較する
			System.out.println((1 == (n & 1)) && (s.equals(getResult((n - 1) / 2))) ? (n - 1) / 2 : -1);
		}
	}

	/**
	 * @param n
	 * @return 手順nの結果
	 */
	private static String getResult(int n) {
		if (0 == n) {
			return "b";
		}
		return switch (n % 3) {
		case 1 -> "a" + getResult(n - 1) + "c";
		case 2 -> "c" + getResult(n - 1) + "a";
		default -> "b" + getResult(n - 1) + "b";
		};
	}
}
