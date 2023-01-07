package other.typical90;

import java.util.Arrays;
import java.util.Scanner;

public class Problem084 {

	/** oを表す文字 */
	private static final char O = 'o';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			char[] s = scanner.next().toCharArray();
			int[] counts = new int[2];
			Arrays.fill(counts, 0);
			int left = 0, right = 0;
			long answer = 0L;
			while (true) {
				while ((right < n) && ((0 == counts[0]) || (0 == counts[1]))) {
					counts[(O == s[right++]) ? 0 : 1]++;
				}
				if ((0 == counts[0]) || (0 == counts[1])) {
					break;
				}
				answer += n - right + 1;
				counts[(O == s[left++]) ? 0 : 1]--;
			}
			System.out.println(answer);
		}
	}
}
