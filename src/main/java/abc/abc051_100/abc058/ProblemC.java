package abc.abc051_100.abc058;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	/** 文字の数 */
	private static final int N = 26;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			char[][] s = new char[n][];
			IntStream.range(0, n).forEach(i -> s[i] = scanner.next().toCharArray());
			int[] result = new int[N], temp = new int[N];
			if (n > 0) {
				calcResult(s[0], result, result);
				IntStream.range(1, s.length).forEach(i -> calcResult(s[i], temp, result));
			}
			System.out.println(getResult(result));
		}
	}

	/**
	 * @param s      文字列
	 * @param temp   一時計算結果格納用
	 * @param result 共通計算結果格納用
	 */
	private static void calcResult(char[] s, int[] temp, int[] result) {
		Arrays.fill(temp, 0);
		IntStream.range(0, s.length).forEach(i -> temp[s[i] - 'a']++);
		if (temp != result) {
			// 2回目以降の実行ではtempとresultをマージする
			IntStream.range(0, N).forEach(i -> result[i] = Math.min(temp[i], result[i]));
		}
	}

	/**
	 * @param result 各文字の数
	 * @return 計算結果
	 */
	private static String getResult(int[] result) {
		StringBuilder sb = new StringBuilder();
		IntStream.range(0, N).forEach(i -> IntStream.range(0, result[i]).forEach(j -> sb.append((char) (i + 'a'))));
		return sb.toString();
	}
}
