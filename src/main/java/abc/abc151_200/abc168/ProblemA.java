package abc.abc151_200.abc168;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			switch (s[s.length - 1]) {
			case '0', '1', '6', '8' -> System.out.println("pon");
			case '2', '4', '5', '7', '9' -> System.out.println("hon");
			default -> System.out.println("bon");
			}
		}
	}
}
