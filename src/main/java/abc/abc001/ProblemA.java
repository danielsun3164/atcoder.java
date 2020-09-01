package abc.abc001;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h1 = scanner.nextInt();
			int h2 = scanner.nextInt();
			System.out.println(h1 - h2);
		}
	}
}
