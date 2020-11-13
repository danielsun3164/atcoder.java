package other.exawizards2019;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int c = scanner.nextInt();
			scanner.nextLine();
			if ((a == b) && (a == c)) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
	}
}
