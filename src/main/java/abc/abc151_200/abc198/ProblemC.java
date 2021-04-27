package abc.abc151_200.abc198;

import java.util.Scanner;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int r = scanner.nextInt(), x = scanner.nextInt(), y = scanner.nextInt();
			double dist = Math.hypot(x, y);
			if (dist == r) {
				System.out.println(1);
			} else if (dist <= (2 * r)) {
				System.out.println(2);
			} else {
				System.out.println((int) Math.ceil(dist / r));
			}
		}
	}
}
