package abc.abc201_250.abc215;

import java.util.Scanner;

/**
 * Long.numberOfLeadingZerosを利用した実装
 */
public class ProblemB別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			System.out.println(Long.SIZE - 1 - Long.numberOfLeadingZeros(n));
		}
	}
}
