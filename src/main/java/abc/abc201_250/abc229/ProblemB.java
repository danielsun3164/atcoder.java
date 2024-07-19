package abc.abc201_250.abc229;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] a = scanner.next().toCharArray(), b = scanner.next().toCharArray();
			reverse(a);
			reverse(b);
			for (int i = 0; i < Math.min(a.length, b.length); i++) {
				if (a[i] - '0' + b[i] - '0' > 9) {
					System.out.println("Hard");
					return;
				}
			}
			System.out.println("Easy");
		}
	}

	/**
	 * 文字列sの順序を逆にする
	 *
	 * @param s 文字列
	 */
	private static void reverse(char[] s) {
		int n = s.length;
		IntStream.range(0, n >> 1).forEach(i -> {
			char t = s[i];
			s[i] = s[n - 1 - i];
			s[n - 1 - i] = t;
		});
	}
}
