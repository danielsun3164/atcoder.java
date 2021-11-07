package abc.abc151_200.abc151;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] c = scanner.next().toCharArray();
			System.out.println(++c[0]);
		}
	}
}
