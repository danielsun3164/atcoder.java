package abc.abc002;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String w = scanner.nextLine();
			System.out.println(w.replaceAll("[aiueo]", ""));
		}
	}
}
