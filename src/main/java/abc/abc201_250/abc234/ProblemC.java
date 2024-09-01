package abc.abc201_250.abc234;

import java.util.Scanner;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long k = scanner.nextLong();
			System.out.println(Long.toBinaryString(k).replaceAll("1", "2"));
		}
	}
}
