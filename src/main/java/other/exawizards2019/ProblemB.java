package other.exawizards2019;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int count = scanner.nextInt();
			scanner.nextLine();
			String string = scanner.nextLine();
			if (string.chars().filter(x -> x == 'R').count() > count / 2) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
	}
}
