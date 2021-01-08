package abc.abc001_050.abc020;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String a = scanner.next(), b = scanner.next();
			System.out.println(Integer.parseInt(a + b) * 2);
		}
	}
}
