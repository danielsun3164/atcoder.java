package abc.abc001_050.abc017;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[] result = new int[m + 1];
			Arrays.fill(result, 0);
			int sum = IntStream.range(0, n).map(i -> {
				int l = scanner.nextInt() - 1, r = scanner.nextInt(), s = scanner.nextInt();
				result[l] += s;
				result[r] -= s;
				return s;
			}).sum();
			IntStream.range(0, m).forEach(i -> result[i + 1] += result[i]);
			result[m] = Integer.MAX_VALUE;
			System.out.println(sum - Arrays.stream(result).min().getAsInt());
		}
	}
}
