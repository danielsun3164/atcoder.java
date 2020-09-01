package abc.abc084;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			String s = scanner.next();
			System.out.println(s.matches("[0-9]{" + a + "}-[0-9]{" + b + "}") ? "Yes" : "No");
		}
	}
}
