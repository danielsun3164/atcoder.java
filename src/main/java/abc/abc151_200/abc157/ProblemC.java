package abc.abc151_200.abc157;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	/** ゼロを表す文字 */
	private static final char ZERO = '0';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			char[] answer = new char[n];
			Arrays.fill(answer, (char) 0);
			int[] s = new int[m], c = new int[m];
			IntStream.range(0, m).forEach(i -> {
				s[i] = scanner.nextInt() - 1;
				c[i] = scanner.nextInt();
			});
			for (int i = 0; i < m; i++) {
				if ((answer[s[i]] != 0) && (answer[s[i]] != (c[i] + ZERO))) {
					System.out.println(-1);
					return;
				}
				answer[s[i]] = (char) (ZERO + c[i]);
			}
			for (int i = 0; i < n; i++) {
				answer[i] = (0 == answer[i]) ? (((1 == n) || (i > 0)) ? ZERO : '1') : answer[i];
			}
			if ((n > 1) && (ZERO == answer[0])) {
				System.out.println(-1);
			} else {
				System.out.println(answer);
			}
		}
	}
}
