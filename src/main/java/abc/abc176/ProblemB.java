package abc.abc176;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] n = scanner.next().toCharArray();
			int sum = 0;
			for (int i = 0; i < n.length; i++) {
				sum = (sum + (n[i] - '0')) % 9;
			}
			System.out.println((0 == sum) ? "Yes" : "No");
		}
	}
}
