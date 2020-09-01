package abc.abc168;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			switch (s[s.length - 1]) {
			case '0':
			case '1':
			case '6':
			case '8':
				System.out.println("pon");
				break;
			case '2':
			case '4':
			case '5':
			case '7':
			case '9':
				System.out.println("hon");
				break;
			default:
				System.out.println("bon");
			}
		}
	}
}
