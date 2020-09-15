package abc.abc003;

import java.util.Scanner;
import java.util.Set;

public class ProblemB {

	/** アットマークが置き換えられる文字のセット */
	private static Set<Character> SET = Set.of('a', 't', 'c', 'o', 'd', 'e', 'r', '@');
	/** アットマーク */
	private static char AT_MARK = '@';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char s[] = scanner.next().toCharArray();
			char t[] = scanner.next().toCharArray();
			boolean result = true;
			if (s.length == t.length) {
				for (int i = 0; i < s.length; i++)
					if (AT_MARK == s[i]) {
						if (!SET.contains(t[i])) {
							result = false;
							break;
						}
					} else if (AT_MARK == t[i]) {
						if (!SET.contains(s[i])) {
							result = false;
							break;
						}
					} else if (s[i] != t[i]) {
						result = false;
						break;
					}
			}
			if (result) {
				System.out.println("You can win");
			} else {
				System.out.println("You will lose");
			}
		}
	}
}
