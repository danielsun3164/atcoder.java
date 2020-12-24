package abc.abc051_100.abc083;

import java.util.Scanner;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long x = scanner.nextLong(), y = scanner.nextLong();
			System.out.println(getDigits(y / x));
		}
	}

	/**
	 * @param l
	 * @return lの2進数の桁数
	 */
	private static int getDigits(long l) {
		int result = 0;
		while (l > 0) {
			l >>= 1;
			result++;
		}
		return result;
	}
}
