package abc.abc151_200.abc152;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	/** 10 */
	private static final int N = 10;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[][] count = new int[N][N];
			IntStream.rangeClosed(1, n).forEach(i -> count[firstDigit(i)][i % N]++);
			System.out.println(IntStream.range(0, N)
					.map(i -> IntStream.range(0, N).map(j -> count[i][j] * count[j][i]).sum()).sum());
		}
	}

	/**
	 * 数字nの10進数の最初の桁を返す
	 *
	 * @param n
	 * @return 数字nの10進数の最初の桁
	 */
	private static int firstDigit(int n) {
		while (n >= N) {
			n /= N;
		}
		return n;
	}
}
