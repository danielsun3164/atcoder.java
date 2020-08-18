package abc098;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説どおりに作成したソースコード
 * 
 * https://atcoder.jp/contests/abc098/submissions/14897650 にも参考
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] a = new long[n];
			IntStream.range(0, n).forEach(i -> a[i] = scanner.nextLong());
			long answer = 0L, sum = 0L;
			int right = 0;
			for (int left = 0; left < n; left++) {
				while ((right < n) && (sum + a[right] == (sum ^ a[right]))) {
					sum += a[right];
					right++;
				}
				answer += right - left;
				sum -= a[left];
			}
			System.out.println(answer);
		}
	}
}
