package other.typical90;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * stringを昇順で計算するバージョン
 */
public class Problem025別回答 {

	/** 入力数字の最大桁数 */
	private static final int N = 11;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong(), b = scanner.nextLong();
			long answer = IntStream.rangeClosed(1, Math.min(N, String.valueOf(n).length()))
					.mapToLong(i -> dfs(n, b, i, 1, "")).sum();
			System.out.println(answer + (String.valueOf(b).contains("0") && (n >= b) ? 1 : 0));
		}
	}

	/**
	 * 指定された桁数の1以上n以下の整数mの中で m−f(m)=b となるものの個数を再帰的に計算する
	 *
	 * @param n
	 * @param b
	 * @param position 残り桁数
	 * @param last     最後に出た数字
	 * @param string   構築された数字の文字列
	 * @return 指定された桁数の1以上n以下の整数mの中で m−f(m)=b となるものの個数
	 */
	private static long dfs(long n, long b, int position, int last, String string) {
		long result = 0L;
		if (0 == position) {
			long goal = IntStream.range(0, string.length()).mapToLong(i -> string.charAt(i) - '0').reduce(1L,
					(s, i) -> s * i) + b;
			if (goal <= n) {
				char[] goalChars = String.valueOf(goal).toCharArray();
				Arrays.sort(goalChars);
				if (new String(goalChars).equals(string)) {
					result++;
				}
			}
			return result;
		}
		for (int i = last; i <= 9; i++) {
			result += dfs(n, b, position - 1, i, string + i);
		}
		return result;
	}
}
