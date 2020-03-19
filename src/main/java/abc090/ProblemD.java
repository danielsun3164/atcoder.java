package abc090;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			// result[i]はiを割って余りがk以上の数字の数
			long[] result = new long[n + 1];
			Arrays.fill(result, 0L);
			IntStream.rangeClosed(k + 1, n)
					.forEach(i -> result[i] = (n / i) * (i - k) + Math.max((n % i) - Math.max(k - 1, 0), 0));
			System.out.println(Arrays.stream(result).sum());
		}
	}
}
