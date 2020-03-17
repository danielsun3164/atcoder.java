package abc086;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String s = scanner.nextLine();
			int ab = Integer.parseInt(s.replaceAll(" ", ""));
			int sqrt = (int) Math.sqrt(ab);
			System.out.println((sqrt * sqrt == ab) ? "Yes" : "No");
		}
	}
}
