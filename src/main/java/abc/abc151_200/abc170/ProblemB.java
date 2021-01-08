package abc.abc151_200.abc170;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int x = scanner.nextInt(), y = scanner.nextInt();
			System.out.println(((x * 2 <= y) && (x * 4 >= y) && (0 == (y & 1))) ? "Yes" : "No");
		}
	}
}
