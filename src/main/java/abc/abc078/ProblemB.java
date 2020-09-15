package abc.abc078;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int x = scanner.nextInt(), y = scanner.nextInt(), z = scanner.nextInt();
			System.out.println((x - z) / (y + z));
		}
	}
}
