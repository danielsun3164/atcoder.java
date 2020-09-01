package abc.abc100;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt();
			System.out.println(((a <= 8) & (b <= 8)) ? "Yay!" : ":(");
		}
	}
}
