package abc.abc201_250.abc245;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt(), d = scanner.nextInt();
			System.out.println((a * 60 + b <= c * 60 + d) ? "Takahashi" : "Aoki");
		}
	}
}
