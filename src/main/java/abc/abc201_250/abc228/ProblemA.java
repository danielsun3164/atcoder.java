package abc.abc201_250.abc228;

import java.util.Scanner;

public class ProblemA {

	/** １日の時間数 */
	private static final int N = 24;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int s = scanner.nextInt(), t = scanner.nextInt(), x = scanner.nextInt();
			if (t < s) {
				t += N;
				if (x < s) {
					x += N;
				}
			}
			System.out.println(((x >= s) && (x < t)) ? "Yes" : "No");
		}
	}
}
