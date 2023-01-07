package other.typical90;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem064 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), q = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			long[] d = new long[n];
			d[0] = 0L;
			IntStream.range(1, n).forEach(i -> d[i] = a[i] - a[i - 1]);
			long sum = Arrays.stream(d).map(di -> Math.abs(di)).sum();
			// TLE対策のため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			while (q-- > 0) {
				int l = scanner.nextInt() - 1, r = scanner.nextInt();
				long v = scanner.nextLong();
				if (l > 0) {
					long before = d[l];
					d[l] += v;
					sum += Math.abs(d[l]) - Math.abs(before);
				}
				if (r < n) {
					long before = d[r];
					d[r] -= v;
					sum += Math.abs(d[r]) - Math.abs(before);
				}
				sb.append(sum).append(System.lineSeparator());
			}
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
