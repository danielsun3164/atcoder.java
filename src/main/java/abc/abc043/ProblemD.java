package abc.abc043;

import java.util.Scanner;

/**
 * 解説通り実装したソースコード
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			char pre2 = s[0];
			char pre1 = s[1];
			int start = -1, end = -1;
			if (pre2 == pre1) {
				start = 1;
				end = 2;
			} else {
				for (int i = 2; i < s.length; i++) {
					char now = s[i];
					if (pre2 == now) {
						start = i - 1;
						end = i + 1;
						break;
					} else if (pre1 == now) {
						start = i;
						end = i + 1;
						break;
					}
					pre2 = pre1;
					pre1 = now;
				}
			}
			System.out.println(start + " " + end);
		}
	}
}
