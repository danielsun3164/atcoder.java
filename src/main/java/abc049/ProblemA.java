package abc049;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProblemA {

	private static final List<String> list = Arrays.asList("a", "e", "i", "o", "u");

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String s = scanner.nextLine();
			System.out.println(list.contains(s) ? "vowel" : "consonant");
		}
	}
}
