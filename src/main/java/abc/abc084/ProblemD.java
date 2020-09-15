package abc.abc084;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemD {

	/** 計算する最大値 */
	private static final int N = 100_000;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			// Nまでの素数を計算する
			boolean[] isPrime = new boolean[N + 1];
			Arrays.fill(isPrime, true);
			isPrime[0] = isPrime[1] = false;
			IntStream.rangeClosed(2, N).forEach(i -> {
				if (isPrime[i]) {
					IntStream.rangeClosed(2, N / i).forEach(j -> isPrime[j * i] = false);
				}
			});
			// 最大値まで2017に似た数を計算する
			int[] count = new int[N];
			count[0] = count[1] = count[2] = 0;
			IntStream.range(3, N).forEach(i -> count[i] = count[i - 1] + (is2017LikeNumber(i, isPrime) ? 1 : 0));
			int q = scanner.nextInt();
			IntStream.range(0, q).map(i -> {
				int l = scanner.nextInt(), r = scanner.nextInt();
				return count[r] - count[l - 1];
			}).forEach(System.out::println);
		}
	}

	/**
	 * 入力数字が2017に似た数であるかどうかを計算
	 * 
	 * @param number  入力数字
	 * @param isPrime indexが素数かどうかの配列
	 * @return 入力数字が2017に似た数であるかどうか
	 */
	private static boolean is2017LikeNumber(int number, boolean[] isPrime) {
		return (1 == (number & 1)) && isPrime[number] && isPrime[(number + 1) / 2];
	}
}
