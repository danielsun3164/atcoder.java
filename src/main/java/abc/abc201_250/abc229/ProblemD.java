package abc.abc201_250.abc229;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	/** 「.」を表す文字 */
	private static final char DOT = '.';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			int n = s.length, k = scanner.nextInt(), t = (int) IntStream.range(0, n).filter(i -> DOT == s[i]).count();
			if (k >= t) {
				System.out.println(n);
				return;
			}
			int start = 0, end = 0, xCount = 0, dotCount = 0, answer = 0;
			while (end < n) {
				if (DOT == s[end++]) {
					if (dotCount == k) {
						while (start < end) {
							if (DOT == s[start++]) {
								dotCount--;
								break;
							} else {
								xCount--;
							}
						}
						if (dotCount == k) {
							start++;
							continue;
						}
					}
					dotCount++;
				} else {
					xCount++;
				}
				answer = Math.max(answer, xCount + dotCount);
			}
			System.out.println(answer);
		}
	}
}
