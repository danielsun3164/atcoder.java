package other.typical90;

import java.util.Scanner;

/**
 * 解説通りに実装したソースコード
 */
public class Problem075別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			int count = 0, answer = 0;
			for (long p = 2L; p * p <= n; p++) {
				if (0L == n % p) {
					while (0L == n % p) {
						n /= p;
						count++;
					}
				}
			}
			count += (n > 1) ? 1 : 0;
			while ((1 << answer) < count) {
				answer++;
			}
			System.out.println(answer);
		}
	}
}
