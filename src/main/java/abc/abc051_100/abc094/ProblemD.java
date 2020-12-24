package abc.abc051_100.abc094;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).sorted().toArray();
			// 最大値を取得する
			int max = a[n - 1];
			// 最大値/2に一番近い値を取得する
			int[] b = new int[n - 1];
			IntStream.range(0, n - 1).forEach(i -> b[i] = Math.min(a[i], max - a[i]));
			Arrays.sort(b);
			int next = b[n - 2];
			System.out.println(max + " " + ((Arrays.binarySearch(a, next) >= 0) ? next : (max - next)));
		}
	}
}
