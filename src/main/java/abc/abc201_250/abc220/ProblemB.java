package abc.abc201_250.abc220;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int k = scanner.nextInt();
			String a = scanner.next(), b = scanner.next();
			System.out.println(Long.parseLong(a, k) * Long.parseLong(b, k));
		}
	}
}
