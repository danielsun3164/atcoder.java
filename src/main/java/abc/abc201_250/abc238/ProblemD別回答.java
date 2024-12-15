package abc.abc201_250.abc238;

import java.util.Scanner;

/**
 * https://atcoder.jp/contests/abc238/editorial/3512 の判定条件の実装
 */
public class ProblemD別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			while (t-- > 0) {
				long a = scanner.nextLong(), s = scanner.nextLong();
				long b = s - a;
				sb.append(((b >= 0L) && (a == (b & a))) ? "Yes" : "No").append(System.lineSeparator());
			}
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
