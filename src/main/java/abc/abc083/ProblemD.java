package abc.abc083;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説どおりに作成したソースコード
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			int n = s.length;
			System.out.println(
					IntStream.range(1, n).filter(i -> s[i - 1] != s[i]).map(i -> Math.max(i, n - i)).min().orElse(n));
		}
	}
}
