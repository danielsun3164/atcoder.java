package abc.abc201_250.abc247;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String s = scanner.next();
			System.out.println("0" + s.substring(0, 3));
		}
	}
}
