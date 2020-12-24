package abc.abc001_050.abc008;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int s = scanner.nextInt(), t = scanner.nextInt();
			System.out.println(t - s + 1);
		}
	}
}
