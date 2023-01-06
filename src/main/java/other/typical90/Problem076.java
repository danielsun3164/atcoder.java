package other.typical90;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem076 {

	/** 10 */
	private static final long TEN = 10L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] a = new long[n << 1];
			long sum = IntStream.range(0, n).mapToLong(i -> a[i] = a[n + i] = scanner.nextLong()).sum();
			if (0L == sum % TEN) {
				int left = 0, right = 0;
				long target = sum / TEN, now = a[left];
				while (true) {
					while (now < target) {
						now += a[++right];
					}
					if (now == target) {
						System.out.println("Yes");
						return;
					}
					while (now > target) {
						now -= a[left++];
					}
					if (left >= n) {
						break;
					}
				}
			}
			System.out.println("No");
		}
	}
}
