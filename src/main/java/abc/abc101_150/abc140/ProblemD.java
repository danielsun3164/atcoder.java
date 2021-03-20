package abc.abc101_150.abc140;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			char[] s = scanner.next().toCharArray();
			System.out.println(Math.min(n - 1, IntStream.range(1, n).filter(i -> s[i - 1] == s[i]).count() + k * 2));
		}
	}
}
