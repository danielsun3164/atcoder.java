package abc.abc082;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			char[] t = scanner.next().toCharArray();
			Arrays.sort(s);
			Arrays.sort(t);
			for (int i = 0; i < Math.min(s.length, t.length); i++) {
				if (t[t.length - 1 - i] > s[i]) {
					System.out.println("Yes");
					return;
				} else if (t[t.length - 1 - i] < s[i]) {
					System.out.println("No");
					return;
				}
			}
			System.out.println((t.length > s.length) ? "Yes" : "No");
		}
	}
}
