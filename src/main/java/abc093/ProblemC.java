package abc093;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	/** 数字の数 */
	private static final int N = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int[] a = new int[N];
			IntStream.range(0, N).forEach(i -> a[i] = scanner.nextInt());
			Arrays.sort(a);
			System.out.println(getResult(a[N - 1] - a[0], a[N - 1] - a[1]));
		}
	}

	/**
	 * aとbになるための操作回数
	 * 
	 * @param a
	 * @param b
	 * @return 操作回数
	 */
	private static int getResult(int a, int b) {
		// aとbの差分が奇数の場合
		if (1 == ((a - b) & 1)) {
			return getResult(a + 1, b) + 1;
		}
		return (a + b) / 2;
	}
}
