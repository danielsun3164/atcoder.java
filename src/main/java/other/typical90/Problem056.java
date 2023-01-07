package other.typical90;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem056 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), s = scanner.nextInt();
			int[] a = new int[n], b = new int[n];
			IntStream.range(0, n).forEach(i -> {
				a[i] = scanner.nextInt();
				b[i] = scanner.nextInt();
			});
			String[][] result = new String[2][s + 1];
			result[0][0] = "";
			IntStream.range(0, n).forEach(i -> {
				Arrays.fill(result[(i + 1) & 1], null);
				IntStream.rangeClosed(0, s - a[i])
						.filter(j -> (null != result[i & 1][j]) && (null == result[(i + 1) & 1][j + a[i]]))
						.forEach(j -> result[(i + 1) & 1][j + a[i]] = result[i & 1][j] + "A");
				IntStream.rangeClosed(0, s - b[i])
						.filter(j -> (null != result[i & 1][j]) && (null == result[(i + 1) & 1][j + b[i]]))
						.forEach(j -> result[(i + 1) & 1][j + b[i]] = result[i & 1][j] + "B");
			});
			System.out.println((null == result[n & 1][s]) ? "Impossible" : result[n & 1][s]);
		}
	}
}
