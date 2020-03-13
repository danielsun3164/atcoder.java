package abc084;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 自力で作成したソースコード、解説より計算量が多いが、結果がACになっている
 */
public class ProblemD別回答 {

	/** 計算する最大値 */
	private static final int N = 100_000;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			// 最大値まで2017に似た数を計算する
			int[] count = new int[N];
			count[0] = count[1] = count[2] = 0;
			List<Integer> primeList = new ArrayList<>();
			primeList.add(2);
			IntStream.range(3, N).forEach(i -> count[i] = count[i - 1] + (is2017LikeNumber(i, primeList) ? 1 : 0));
			int q = scanner.nextInt();
			IntStream.range(0, q).map(i -> {
				int l = scanner.nextInt();
				int r = scanner.nextInt();
				return count[r] - count[l - 1];
			}).forEach(System.out::println);
		}
	}

	/**
	 * 入力数字が素数かどうかを判定する
	 * 
	 * @param number    入力数字
	 * @param primeList 素数のリスト
	 * @return 入力数字が素数かどうか
	 */
	private static boolean isPrime(int number, List<Integer> primeList) {
		int sqrt = (int) Math.sqrt(number);
		for (int i : primeList) {
			if (i > sqrt) {
				primeList.add(number);
				return true;
			}
			if (0 == (number % i)) {
				return false;
			}
		}
		primeList.add(number);
		return true;
	}

	/**
	 * 入力数字が2017に似た数であるかどうかを計算
	 * 
	 * @param number 入力数字
	 * @return 入力数字が2017に似た数であるかどうか
	 */
	private static boolean is2017LikeNumber(int number, List<Integer> primeList) {
		return (1 == (number & 1)) && isPrime(number, primeList) && primeList.contains((number + 1) / 2);
	}
}
