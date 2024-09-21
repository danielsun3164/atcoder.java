package other.math_and_algorithm;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem040 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] sum = new long[n];
			sum[0] = 0L;
			IntStream.range(1, n).forEach(i -> sum[i] = sum[i - 1] + scanner.nextInt());
			int m = scanner.nextInt(), prev = scanner.nextInt() - 1;
			long answer = 0L;
			for (int i = 1; i < m; i++) {
				int now = scanner.nextInt() - 1;
				answer += Math.abs(sum[prev] - sum[now]);
				prev = now;
			}
			System.out.println(answer);
		}
	}
}
