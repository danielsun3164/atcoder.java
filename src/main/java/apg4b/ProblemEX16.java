package apg4b;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemEX16 {

	/** 整数の数 */
	private static final int N = 5;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int[] a = new int[N];
			IntStream.range(0, N).forEach(i -> a[i] = scanner.nextInt());
			System.out.println((IntStream.range(1, N).filter(i -> a[i] == a[i - 1]).count() > 0) ? "YES" : "NO");
		}
	}
}
