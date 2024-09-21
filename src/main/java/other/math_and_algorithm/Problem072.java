package other.math_and_algorithm;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class Problem072 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt();
			System.out.println(IntStream.rangeClosed(1, b).filter(i -> b / i - (a + i - 1) / i >= 1).max().getAsInt());
		}
	}
}
