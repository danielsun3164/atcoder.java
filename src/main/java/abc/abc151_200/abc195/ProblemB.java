package abc.abc151_200.abc195;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt(), w = scanner.nextInt() * 1000;
			int ca = w / a, cb = (w + b - 1) / b;
			if (ca >= cb) {
				System.out.println(cb + " " + ca);
			} else {
				System.out.println("UNSATISFIABLE");
			}
		}
	}
}
