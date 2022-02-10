package abc.abc151_200.abc158;

import java.util.Scanner;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt();
			for (int i = b * 10; i < (b + 1) * 10; i++) {
				if ((a == i * 8 / 100) && (b == i / 10)) {
					System.out.println(i);
					return;
				}
			}
			System.out.println(-1);
		}
	}
}
