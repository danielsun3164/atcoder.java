package abc.abc001_050.abc045;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			int max = 1 << (s.length - 1);
			System.out.println(IntStream.range(0, max).mapToLong(i -> eval(i, s)).sum());
		}
	}

	/**
	 * @param n 「+」ありなしの2進数
	 * @param s 入力数字の文字列
	 * @return 文字列に「+」を追加した後の数式の計算結果
	 */
	private static long eval(int n, char[] s) {
		StringBuilder sb = new StringBuilder();
		long sum = 0L;
		for (int i = 0; i < s.length - 1; i++) {
			sb.append(s[i]);
			if (1 == ((n >> i) & 1)) {
				sum += Long.parseLong(sb.toString());
				sb.setLength(0);
			}
		}
		// 最後の項目を追加
		sb.append(s[s.length - 1]);
		return sum + Long.parseLong(sb.toString());
	}
}
