package other.joi2008yo;

import java.util.Scanner;

public class ProblemA {

	/** コインの種類 */
	private static final int[] COINS = { 500, 100, 50, 10, 5, 1 };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = 1000 - scanner.nextInt();
			int answer = 0;
			for (int coin : COINS) {
				while (n >= coin) {
					answer++;
					n -= coin;
				}
			}
			System.out.println(answer);
		}
	}
}
