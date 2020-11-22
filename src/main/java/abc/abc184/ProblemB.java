package abc.abc184;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), x = scanner.nextInt();
			char[] s = scanner.next().toCharArray();
			for (int i = 0; i < n; i++) {
				if ('x' == s[i]) {
					if (x > 0) {
						x--;
					}
				} else {
					x++;
				}
			}
			System.out.println(x);
		}
	}
}
