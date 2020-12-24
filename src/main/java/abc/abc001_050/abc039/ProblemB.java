package abc.abc001_050.abc039;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println((int) Math.sqrt(Math.sqrt(n)));
		}
	}
}
