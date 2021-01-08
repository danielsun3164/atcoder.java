package other.exawizards2019;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 * 
 * https://atcoder.jp/contests/exawizards2019/submissions/18389212 にも参照
 */
public class ProblemC {

	/** 左へ移動する文字 */
	private static final char LEFT = 'L';
	/** 右へ移動する文字 */
	private static final char RIGHT = 'R';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), q = scanner.nextInt();
			char[] s = scanner.next().toCharArray();
			char[] t = new char[q], d = new char[q];
			IntStream.range(0, q).forEach(i -> {
				t[i] = scanner.next().charAt(0);
				d[i] = scanner.next().charAt(0);
			});
			int l = 0, r = n - 1;
			for (int i = q - 1; i >= 0; i--) {
				if ((l < n) && (s[l] == t[i]) && (LEFT == d[i])) {
					l++;
				}
				if ((l > 0) && (s[l - 1] == t[i]) && (RIGHT == d[i])) {
					l--;
				}
				if ((r >= 0) && (s[r] == t[i]) && (RIGHT == d[i])) {
					r--;
				}
				if ((r < n - 1) && (s[r + 1] == t[i]) && (LEFT == d[i])) {
					r++;
				}
			}
			System.out.println(Math.max(r - l + 1, 0));
		}
	}
}
