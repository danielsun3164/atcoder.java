package abc.abc041;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.nextLine().toCharArray();
			int i = scanner.nextInt() - 1;
			System.out.println(s[i]);
		}
	}
}
