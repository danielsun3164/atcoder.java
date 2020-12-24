package abc.abc101_150.abc105;

import java.util.Scanner;

public class ProblemB {

	/** ケーキの値段 */
	private static final int CAKE = 4;
	/** ドーナツの値段 */
	private static final int DOUGHNUT = 7;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			for (int i = 0; i <= n / CAKE; i++) {
				if (0 == (n - CAKE * i) % DOUGHNUT) {
					System.out.println("Yes");
					return;
				}
			}
			System.out.println("No");
		}
	}
}
