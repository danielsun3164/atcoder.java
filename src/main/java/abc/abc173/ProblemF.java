package abc.abc173;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 * 
 * https://atcoder.jp/contests/abc173/submissions/15525302 にも参考
 */
public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long answer = IntStream.rangeClosed(1, n).mapToLong(i -> i * (long) (n - i + 1)).sum();
			answer -= IntStream.range(1, n).mapToLong(i -> {
				int u = scanner.nextInt(), v = scanner.nextInt();
				int l = Math.min(u, v), r = Math.max(u, v);
				return l * (long) (n - r + 1);
			}).sum();
			System.out.println(answer);
		}
	}
}
