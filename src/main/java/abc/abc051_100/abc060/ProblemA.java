package abc.abc051_100.abc060;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemA {

	/** 入力文字列の数 */
	private static final int N = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[][] s = new char[N][];
			IntStream.range(0, N).forEach(i -> s[i] = scanner.next().toCharArray());
			boolean result = true;
			for (int i = 1; i < N; i++) {
				// 直前の文字列の最後の文字と現在の文字列の最初の文字と比較
				if (s[i - 1][s[i - 1].length - 1] != s[i][0]) {
					result = false;
					break;
				}
			}
			System.out.println(result ? "YES" : "NO");
		}
	}
}
