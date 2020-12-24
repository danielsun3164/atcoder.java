package abc.abc101_150.abc130;

import java.util.Scanner;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int w = scanner.nextInt(), h = scanner.nextInt(), x = scanner.nextInt(), y = scanner.nextInt();
			System.out.println(((double) w) * h / 2.0d + " " + (((x + x == w) && (y + y == h)) ? 1 : 0));
		}
	}
}
