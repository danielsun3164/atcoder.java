package abc.abc183;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), w = scanner.nextInt();
			int[] s = new int[n], t = new int[n];
			long[] p = new long[n];
			int maxT = IntStream.range(0, n).map(i -> {
				s[i] = scanner.nextInt();
				t[i] = scanner.nextInt();
				p[i] = scanner.nextLong();
				return t[i];
			}).max().getAsInt();
			long[] h = new long[maxT + 1];
			Arrays.fill(h, 0L);
			IntStream.range(0, n).forEach(i -> {
				h[s[i]] += p[i];
				h[t[i]] -= p[i];
			});
			// imos法で計算する
			IntStream.rangeClosed(1, maxT).forEach(i -> h[i] += h[i - 1]);
			System.out.println((Arrays.stream(h).max().getAsLong() <= w) ? "Yes" : "No");
		}
	}
}
