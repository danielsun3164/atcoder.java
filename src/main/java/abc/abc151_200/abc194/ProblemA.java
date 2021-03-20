package abc.abc151_200.abc194;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt();
			if (((a + b) >= 15) && (b >= 8)) {
				System.out.println(1);
			} else if (((a + b) >= 10) && (b >= 3)) {
				System.out.println(2);
			} else if ((a + b) >= 3) {
				System.out.println(3);
			} else {
				System.out.println(4);
			}
		}
	}
}
