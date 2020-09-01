package abc.abc017;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			int[] result = new int[m + 1];
			IntStream.rangeClosed(0, m).forEach(i -> result[i] = 0);
			int sum = 0;
			for (int i = 0; i < n; i++) {
				int l = scanner.nextInt() - 1;
				int r = scanner.nextInt();
				int s = scanner.nextInt();
				result[l] += s;
				result[r] -= s;
				sum += s;
			}
			IntStream.range(0, m).forEach(i -> result[i + 1] += result[i]);
			result[m] = Integer.MAX_VALUE;
			System.out.println(sum - Arrays.stream(result).min().getAsInt());
		}
	}
}
