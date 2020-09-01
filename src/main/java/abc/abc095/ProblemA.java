package abc.abc095;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println(700 + scanner.next().chars().filter(i -> (char) i == 'o').count() * 100);
		}
	}
}
