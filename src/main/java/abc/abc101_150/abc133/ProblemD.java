package abc.abc101_150.abc133;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			// sum[0][i+1]=a[0]+a[2]+...+a[i]
			// sum[1][i+1]=a[1]+a[3]+...+a[i]
			long[][] sum = new long[2][n + 1];
			sum[0][0] = sum[1][0] = 0L;
			IntStream.range(0, n).forEach(i -> {
				sum[i & 1][i + 1] = sum[i & 1][i] + a[i];
				sum[(i + 1) & 1][i + 1] = sum[(i + 1) & 1][i];
			});
			// i番目の要素の値は (+-)a[0](+-)...+a[i-3]-a[i-2]+a[i-1]+a[i]-a[i+1]+a[i+2]...a[n-1]
			System.out.println(IntStream
					.range(0, n).mapToObj(i -> String.valueOf(sum[(i + 1) & 1][i] - sum[i & 1][i] + sum[i & 1][n]
							- sum[i & 1][i] - sum[(i + 1) & 1][n] + sum[(i + 1) & 1][i]))
					.collect(Collectors.joining(" ")));
		}
	}
}
