package abc.abc101_150.abc141;

import java.util.Scanner;
import java.util.Set;

public class ProblemB {

	/** 奇数文字の一覧 */
	private static final Set<Character> EVEN_SET = Set.of('R', 'U', 'D');
	/** 偶数文字の一覧 */
	private static final Set<Character> ODD_SET = Set.of('L', 'U', 'D');

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			boolean result = true;
			for (int i = 0; i < s.length; i++) {
				if (1 == (i & 1)) {
					// 0-indexのため、偶数文字
					if (!ODD_SET.contains(s[i])) {
						result = false;
						break;
					}
				} else {
					if (!EVEN_SET.contains(s[i])) {
						result = false;
						break;
					}
				}
			}
			System.out.println(result ? "Yes" : "No");
		}
	}
}
