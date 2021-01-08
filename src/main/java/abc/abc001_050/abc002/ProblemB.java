package abc.abc001_050.abc002;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String w = scanner.next();
			System.out.println(w.replaceAll("[aiueo]", ""));
		}
	}
}
