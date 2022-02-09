package abc.abc151_200.abc158;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 *
 * https://atcoder.jp/contests/abc158/submissions/10645244 にも参考
 */
public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), p = scanner.nextInt();
			char[] s = scanner.next().toCharArray();
			// 文字列を数字に変換
			int[] s2 = new int[n];
			IntStream.range(0, n).forEach(i -> s2[i] = s[i] - '0');
			if ((2 == p) || (5 == p)) {
				System.out.println(IntStream.range(0, n).mapToLong(i -> (0 == s2[i] % p) ? i + 1 : 0L).sum());
			} else {
				long answer = 0L;
				int now = 0, digit = 1;
				int[] m = new int[p];
				Arrays.fill(m, 0);
				m[0] = 1;
				for (int i = n - 1; i >= 0; i--) {
					now = (now + s2[i] * digit) % p;
					answer += m[now];
					m[now]++;
					digit = digit * 10 % p;
				}
				System.out.println(answer);
			}
		}
	}
}
