package other.abl;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long a = scanner.nextLong(), b = scanner.nextLong(), c = scanner.nextLong(), d = scanner.nextLong();
			System.out.println(((d < a) || (b < c)) ? "No" : "Yes");
		}
	}
}
