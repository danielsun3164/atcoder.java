package abc.abc054;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int rankA = getRank(a), rankB = getRank(b);
			System.out.println((rankA == rankB) ? "Draw" : (rankA > rankB) ? "Alice" : "Bob");
		}
	}

	/**
	 * @param n 入力カード
	 * @return 入力カードのランク
	 */
	private static int getRank(int n) {
		return (n + 11) % 13;
	}
}
