package abc.abc201_250.abc239;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	/** 200 */
	private static final int N = 200;
	private static boolean[] isPrime;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			init();
			int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt(), d = scanner.nextInt();
			// ２つの素数の間の最大距離
			int dist = 1, max = 0;
			for (int i = a + c; i <= b + d; i++, dist++) {
				if (isPrime[i]) {
					max = Math.max(max, dist);
					dist = 0;
				}
			}
			max = Math.max(max, dist);
			System.out.println((max > d - c + 1) ? "Takahashi" : "Aoki");
		}
	}

	/**
	 * 200以内数字が素数かどうかを計算する
	 */
	private static void init() {
		isPrime = new boolean[N + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		IntStream.rangeClosed(2, N).filter(i -> isPrime[i])
				.forEach(i -> IntStream.iterate(i + i, j -> j <= N, j -> j + i).forEach(j -> isPrime[j] = false));
	}
}
