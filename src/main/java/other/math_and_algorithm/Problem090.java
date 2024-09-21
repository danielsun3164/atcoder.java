package other.math_and_algorithm;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class Problem090 {

	private static long n, b, answer;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			n = scanner.nextLong();
			b = scanner.nextLong();
			answer = 0L;
			IntStream.rangeClosed(1, Math.min(11, String.valueOf(n).length())).forEach(i -> dfs(i, 9, ""));
			System.out.println(answer + ((String.valueOf(b).contains("0") && (n >= b)) ? 1 : 0));
		}
	}

	/**
	 * 結果を再帰的に計算する
	 *
	 * @param pos
	 * @param last
	 * @param str
	 */
	private static void dfs(int pos, int last, String str) {
		if (0 == pos) {
			long goal = IntStream.range(0, str.length()).mapToLong(i -> str.charAt(i) - '0').reduce(1L, (s, i) -> s * i)
					+ b;
			if ((goal <= n) && (str.equals(reverseSort(String.valueOf(goal))))) {
				answer++;
			}
		} else {
			for (int i = last; i >= 1; i--) {
				dfs(pos - 1, i, str + i);
			}
		}
	}

	/**
	 * 文字列を大きいから小さい順でソートする
	 *
	 * @param str
	 * @return ソートした結果
	 */
	private static String reverseSort(String str) {
		char[] cs = str.toCharArray();
		Arrays.sort(cs);
		int n = cs.length;
		IntStream.range(0, n >> 1).forEach(i -> {
			char temp = cs[i];
			cs[i] = cs[n - 1 - i];
			cs[n - 1 - i] = temp;
		});
		return new String(cs);
	}
}
