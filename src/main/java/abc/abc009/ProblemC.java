package abc.abc009;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			scanner.nextLine();
			// 入力文字列
			char[] s = scanner.nextLine().toCharArray();
			// 文字列をソートしたもの
			char[] sortedS = s.clone();
			Arrays.sort(sortedS);
			StringBuilder answer = new StringBuilder();
			IntStream.range(0, n).forEach(i -> {
				for (int j = 0; j < n; j++) {
					if (sortedS[j] != 0) {
						char c = sortedS[j];
						sortedS[j] = 0;
						if (n - count(s, answer, sortedS, c) <= k) {
							answer.append(c);
							break;
						} else {
							sortedS[j] = c;
						}
					}
				}
			});
			System.out.println(answer.toString());
		}
	}

	/**
	 * @param s       入力文字列
	 * @param answer  現在の回答文字列
	 * @param sortedS まだ使用されていない文字列（使用されたものは0となる）
	 * @param c       次に追加したい文字
	 * @return 次に追加したい文字を追加する場合、変更しない文字数
	 */
	private static int count(char[] s, StringBuilder answer, char[] sortedS, char c) {
		int count = 0;
		// 入力文字列のアルファベットのそれぞれの数
		int[] countS = new int[26];
		IntStream.range(answer.length() + 1, s.length).forEach(i -> countS[s[i] - 'a']++);
		// 残り文字列のアルファベットのそれぞれの数
		int[] countSortedS = new int[26];
		IntStream.range(0, sortedS.length).filter(i -> (0 != sortedS[i]))
				.forEach(i -> countSortedS[sortedS[i] - 'a']++);
		count += IntStream.range(0, answer.length()).filter(i -> answer.charAt(i) == s[i]).count();
		if (c == s[answer.length()]) {
			count++;
		}
		count += IntStream.range(0, 26).map(i -> Math.min(countS[i], countSortedS[i])).sum();
		return count;
	}
}
