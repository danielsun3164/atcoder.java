package abc.abc201_250.abc201;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemC {

	/** パスワードの桁数 */
	private static final int N = 4;
	/** 必ず含まれる文字 */
	private static final char MUST = 'o';
	/** 必ず含まれない文字 */
	private static final char NG = 'x';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			int n = s.length;
			Set<Integer> mustSet = IntStream.range(0, n).filter(i -> MUST == s[i]).boxed().collect(Collectors.toSet());
			Set<Integer> ngSet = IntStream.range(0, n).filter(i -> NG == s[i]).boxed().collect(Collectors.toSet());
			int[] buffer = new int[N];
			Arrays.fill(buffer, 0);
			int answer = 0;
			while (true) {
				if (ok(buffer, mustSet, ngSet)) {
					answer++;
				}
				if (next(buffer)) {
					break;
				}
			}
			System.out.println(answer);
		}
	}

	/**
	 * bufferで表すパスワードが条件に満たすかどうかを計算する
	 *
	 * @param buffer  パスワード
	 * @param mustSet 必ず含まれる数字のセット
	 * @param ngSet   必ず含まれない数字のセット
	 * @return bufferで表すパスワードが条件に満たすかどうか
	 */
	private static boolean ok(int[] buffer, Set<Integer> mustSet, Set<Integer> ngSet) {
		Set<Integer> bufferSet = Arrays.stream(buffer).boxed().collect(Collectors.toSet());
		for (int must : mustSet) {
			if (!bufferSet.contains(must)) {
				return false;
			}
		}
		for (int b : buffer) {
			if (ngSet.contains(b)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * パスワードを表す配列の次のパスワードを計算する
	 *
	 * @param buffer パスワードを表す配列
	 * @return すでに最後に達したかどうか
	 */
	private static boolean next(int[] buffer) {
		int i = 0;
		while (true) {
			if (buffer[i] < 9) {
				buffer[i]++;
				return false;
			} else {
				buffer[i] = 0;
				i++;
				if (i >= N) {
					break;
				}
			}
		}
		return true;
	}
}
