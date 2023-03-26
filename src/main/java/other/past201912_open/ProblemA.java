package other.past201912_open;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String s = scanner.next();
			try {
				System.out.println(2 * Integer.parseInt(s));
			} catch (NumberFormatException e) {
				System.out.println("error");
			}
		}
	}
}
