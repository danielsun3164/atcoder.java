package abc.abc201_250.abc243;

import java.util.Scanner;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc243/editorial/3511 の解法2の実装
 */
public class ProblemD別回答 {

	private static final char UP = 'U';
	private static final char LEFT = 'L';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			StringBuilder x = new StringBuilder(Long.toBinaryString(scanner.nextLong()));
			char[] s = scanner.next().toCharArray();
			for (int i = 0; i < n; i++) {
				if (UP == s[i]) {
					x = x.deleteCharAt(x.length() - 1);
				} else if (LEFT == s[i]) {
					x = x.append('0');
				} else {
					x = x.append('1');
				}
			}
			System.out.println(Long.parseLong(x.toString(), 2));
		}
	}
}
