package abc.abc101_150.abc150;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			@SuppressWarnings("unused")
			int n = scanner.nextInt();
			String s = scanner.next();
			int count = 0, start = 0, index;
			while ((index = s.indexOf("ABC", start)) >= 0) {
				count++;
				start = index + 1;
			}
			System.out.println(count);
		}
	}
}
