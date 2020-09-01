package abc.abc038;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h1 = scanner.nextInt();
			int w1 = scanner.nextInt();
			int h2 = scanner.nextInt();
			int w2 = scanner.nextInt();
			System.out.println(((h1 == h2) || (h1 == w2) || (w1 == h2) || (w1 == w2)) ? "YES" : "NO");
		}
	}
}
