package abc.abc025;

import java.util.Scanner;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			int n = scanner.nextInt() - 1;
			System.out.println(s[n / s.length] + "" + s[n % s.length]);
		}
	}
}
