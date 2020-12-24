package abc.abc051_100.abc055;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemD {

	/** 羊の定義 */
	private static final char SHEEP = 'S';
	/** 狼の定義 */
	private static final char WOLF = 'W';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			char[] s = scanner.next().toCharArray();
			boolean[] b = new boolean[n];
			IntStream.range(0, n).forEach(i -> b[i] = (s[i] == 'o'));
			char[] result = new char[n];
			result[0] = SHEEP;
			result[1] = SHEEP;
			if (checkResult(n, b, result)) {
				System.out.println(result);
				return;
			}
			result[0] = SHEEP;
			result[1] = WOLF;
			if (checkResult(n, b, result)) {
				System.out.println(result);
				return;
			}
			result[0] = WOLF;
			result[1] = WOLF;
			if (checkResult(n, b, result)) {
				System.out.println(result);
				return;
			}
			result[0] = WOLF;
			result[1] = SHEEP;
			if (checkResult(n, b, result)) {
				System.out.println(result);
				return;
			}
			System.out.println(-1);
		}
	}

	/**
	 * @param n
	 * @param b
	 * @param result
	 * @return このまま矛盾することなく計算できるかどうか
	 */
	private static boolean checkResult(int n, boolean[] b, char[] result) {
		// 2〜n-1まで動物を計算
		IntStream.range(2, n).forEach(i -> {
			if (WOLF == result[i - 1]) {
				result[i] = (b[i - 1]) ? reverse(result[i - 2]) : result[i - 2];
			} else {
				result[i] = (b[i - 1]) ? result[i - 2] : reverse(result[i - 2]);
			}
		});
		boolean lastOk = false, firstOk = false;
		if (WOLF == result[n - 1]) {
			lastOk = (b[n - 1]) ? (result[0] != result[n - 2]) : (result[0] == result[n - 2]);
		} else {
			lastOk = (b[n - 1]) ? (result[0] == result[n - 2]) : (result[0] != result[n - 2]);
		}
		if (WOLF == result[0]) {
			firstOk = (b[0]) ? (result[1] != result[n - 1]) : (result[1] == result[n - 1]);
		} else {
			firstOk = (b[0]) ? (result[1] == result[n - 1]) : (result[1] != result[n - 1]);
		}
		return lastOk && firstOk;
	}

	/**
	 * @param c
	 * @return cの反対の動物
	 */
	private static char reverse(char c) {
		return (c == SHEEP) ? WOLF : SHEEP;
	}
}
