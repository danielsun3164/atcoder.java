package abc.abc201_250.abc221;

import java.util.Scanner;

public class ProblemA {

	/** マグニチュードの強さの倍数 */
	private static final int N = 5;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt();
			System.out.println(1L << ((a - b) * N));
		}
	}
}
