package abc.abc001_050.abc028;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			if (n < 60) {
				System.out.println("Bad");
			} else if ((n >= 60) && (n < 90)) {
				System.out.println("Good");
			} else if ((n >= 90) && (n < 100)) {
				System.out.println("Great");
			} else {
				System.out.println("Perfect");
			}
		}
	}
}
