package abc.abc101_150.abc138;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt();
			String s = scanner.next();
			System.out.println((a >= 3200) ? s : "red");
		}
	}
}
