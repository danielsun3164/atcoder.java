package abc.abc101_150.abc125;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] a = new long[n];
			// 負の数の数
			int minusCount = (int) IntStream.range(0, n).mapToLong(i -> a[i] = scanner.nextLong()).filter(ai -> ai < 0)
					.count();
			// 絶対値の合計
			long sum = Arrays.stream(a).map(Math::abs).sum();
			System.out.println(
					(1 == (minusCount & 1)) ? sum - 2 * Arrays.stream(a).map(Math::abs).min().getAsLong() : sum);
		}
	}
}
