package abc.abc077;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] c1 = scanner.next().toCharArray();
			char[] c2 = scanner.next().toCharArray();
			int n = c1.length;
			boolean result = false;
			if (n == c2.length) {
				result = true;
				for (int i = 0; i < n; i++) {
					if (c1[i] != c2[n - 1 - i]) {
						result = false;
						break;
					}
				}
			}
			System.out.println(result ? "YES" : "NO");
		}
	}
}
