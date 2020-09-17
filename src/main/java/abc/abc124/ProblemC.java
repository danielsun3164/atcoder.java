package abc.abc124;

import java.util.Scanner;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			int count1 = 0, count2 = 0;
			for (int i = 0; i < s.length; i++) {
				char t = (0 == (i & 1)) ? '0' : '1';
				if (s[i] != t) {
					count1++;
				} else {
					count2++;
				}
			}
			System.out.println(Math.min(count1, count2));
		}
	}
}
