package abc.abc169;

import java.util.Scanner;

/**
 * https://atcoder.jp/contests/abc169/submissions/14595332 を参考に作成
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			int sqrt = (int) Math.sqrt(n);
			int answer = 0;
			for (int i = 2; i <= sqrt; i++) {
				int count = 0;
				while (0 == (n % i)) {
					n /= i;
					count++;
				}
				for (int j = 1; count - j >= 0; j++) {
					count -= j;
					answer++;
				}
			}
			if (n > 1) {
				answer++;
			}
			System.out.println(answer);
		}
	}
}
