package abc.abc001_050.abc046;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			System.out.println(k * ((long) Math.pow(k - 1, n - 1)));
		}
	}
}
