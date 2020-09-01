package abc.abc038;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String s = scanner.nextLine();
			System.out.println(("T".equals(s.substring(s.length() - 1))) ? "YES" : "NO");
		}
	}
}
