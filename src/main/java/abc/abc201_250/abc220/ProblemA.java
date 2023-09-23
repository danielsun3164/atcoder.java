package abc.abc201_250.abc220;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt();
			int ac = (a + c - 1) / c, bc = b / c;
			System.out.println((ac > bc) ? -1 : ac * c);
		}
	}
}
