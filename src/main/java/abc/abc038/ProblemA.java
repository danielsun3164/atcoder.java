package abc.abc038;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String s = scanner.next();
			System.out.println(s.endsWith("T") ? "YES" : "NO");
		}
	}
}
