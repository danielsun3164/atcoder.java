package abc.abc201_250.abc216;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String[] s = scanner.next().split("\\.");
			switch (s[1]) {
			case "0", "1", "2" -> System.out.println(s[0] + "-");
			case "3", "4", "5", "6" -> System.out.println(s[0]);
			case "7", "8", "9" -> System.out.println(s[0] + "+");
			}
		}
	}
}
