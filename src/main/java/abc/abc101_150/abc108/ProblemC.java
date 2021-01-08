package abc.abc101_150.abc108;

import java.util.Scanner;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			long count = n / k;
			long answer = count * count * count;
			if (0 == (k & 1)) {
				// kが2の倍数のとき
				long count2 = n / k + ((n % k >= k / 2) ? 1 : 0);
				answer += count2 * count2 * count2;
			}
			System.out.println(answer);
		}
	}
}
