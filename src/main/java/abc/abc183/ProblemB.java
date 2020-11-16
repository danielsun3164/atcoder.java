package abc.abc183;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int sx = scanner.nextInt(), sy = -scanner.nextInt();
			int gx = scanner.nextInt(), gy = scanner.nextInt();
			System.out.println(sx + (gx - sx) / (double) (gy - sy) * (-sy));
		}
	}
}
