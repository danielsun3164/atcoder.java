package abc.abc201_250.abc216;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String[] s = scanner.next().split("\\.");
			switch (s[1]) {
			case "0":
			case "1":
			case "2":
				System.out.println(s[0] + "-");
				break;
			case "3":
			case "4":
			case "5":
			case "6":
				System.out.println(s[0]);
				break;
			case "7":
			case "8":
			case "9":
			default:
				System.out.println(s[0] + "+");
				break;
			}
		}
	}
}
