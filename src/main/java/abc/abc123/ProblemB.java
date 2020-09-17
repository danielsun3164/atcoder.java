package abc.abc123;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	/** 料理の数 */
	private static final int N = 5;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int[] n = IntStream.range(0, N).map(i -> scanner.nextInt()).boxed().sorted((x, y) -> {
				int xremain = x % 10, yremain = y % 10;
				return Integer.compare((yremain == 0) ? 10 : yremain, (xremain == 0) ? 10 : xremain);
			}).mapToInt(Integer::intValue).toArray();
			int sum = Arrays.stream(n).limit(N - 1).map(i -> ceiling10(i)).sum() + n[N - 1];
			System.out.println(sum);
		}
	}

	/**
	 * ceiling(n/10)*10 を計算する
	 * 
	 * @param n
	 * @return ceiling(n/10)*10
	 */
	private static int ceiling10(int n) {
		return (n + 9) / 10 * 10;
	}
}
