package abc.abc201_250.abc233;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc233/editorial/3174 の実装
 */
public class ProblemE別回答 {

	/** 10 */
	private static final int TEN = 10;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] x = scanner.next().toCharArray();
			int n = x.length;
			int s = IntStream.range(0, n).map(i -> x[i] - '0').sum(), c = 0;
			StringBuilder answer = new StringBuilder();
			for (int i = n - 1;; i--) {
				c += s;
				answer.append(c % TEN);
				c /= TEN;
				if (i >= 0) {
					s -= x[i] - '0';
				}
				if ((i <= 0) && (0 == c)) {
					break;
				}
			}
			System.out.println(answer.reverse().toString());
		}
	}
}
