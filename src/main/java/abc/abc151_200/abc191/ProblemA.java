package abc.abc151_200.abc191;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int v = scanner.nextInt(), t = scanner.nextInt(), s = scanner.nextInt(), d = scanner.nextInt();
			System.out.println(((v * t <= d) && (v * s >= d)) ? "No" : "Yes");
		}
	}
}
