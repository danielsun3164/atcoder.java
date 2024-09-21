package other.math_and_algorithm;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem041 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt(), n = scanner.nextInt();
			int[] a = new int[t + 1];
			IntStream.range(0, n).forEach(i -> {
				int l = scanner.nextInt(), r = scanner.nextInt();
				a[l]++;
				a[r]--;
			});
			IntStream.range(1, t).forEach(i -> a[i] += a[i - 1]);
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			Arrays.stream(a, 0, t).forEach(ai -> sb.append(ai).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
