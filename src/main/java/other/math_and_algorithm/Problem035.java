package other.math_and_algorithm;

import java.util.Scanner;

public class Problem035 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int x1 = scanner.nextInt(), y1 = scanner.nextInt(), r1 = scanner.nextInt(), x2 = scanner.nextInt(),
					y2 = scanner.nextInt(), r2 = scanner.nextInt();
			double d = Math.hypot(x1 - x2, y1 - y2), dr = Math.abs(r1 - r2), sr = r1 + r2;
			int answer = 0;
			if (d < dr) {
				answer = 1;
			} else if (d == dr) {
				answer = 2;
			} else if ((d > dr) && (d < sr)) {
				answer = 3;
			} else if (d == sr) {
				answer = 4;
			} else {
				answer = 5;
			}
			System.out.println(answer);
		}
	}
}
