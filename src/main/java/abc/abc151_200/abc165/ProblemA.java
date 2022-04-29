package abc.abc151_200.abc165;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int k = scanner.nextInt(), a = scanner.nextInt(), b = scanner.nextInt();
			System.out.println(((0 == (a % k)) || ((a / k) != (b / k))) ? "OK" : "NG");
		}
	}
}
