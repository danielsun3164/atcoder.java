package other.math_and_algorithm;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem062 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long k = scanner.nextLong();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt() - 1).toArray();
			int[] index = new int[n], result = new int[n << 1];
			Arrays.fill(index, -1);
			int idx = 0, now = 0;
			result[idx] = now;
			while (idx < k) {
				idx++;
				now = a[now];
				if (-1 == index[now]) {
					index[now] = idx;
					result[idx] = now;
				} else {
					int start = index[now];
					System.out.println(result[(int) ((k - start) % (idx - start) + start)] + 1);
					return;
				}
			}
			System.out.println(now + 1);
		}
	}
}
