package abc.abc182;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * https://atcoder.jp/contests/abc182/editorial/290 の実装方法
 */
public class ProblemC別回答 {

	/** 3の倍数を計算する */
	private static final int N = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			int[] s = digits(n), cnt = new int[N];
			Arrays.stream(s).forEach(si -> cnt[si % N]++);
			int sum = Arrays.stream(s).sum();
			int answer = 0;
			if (0 == (sum % N)) {
				answer = 0;
			} else if (1 == (sum % N)) {
				if (cnt[1] > 0) {
					answer = (1 == s.length) ? -1 : 1;
				} else {
					answer = (2 == s.length) ? -1 : 2;
				}
			} else {
				if (cnt[2] > 0) {
					answer = (1 == s.length) ? -1 : 1;
				} else {
					answer = (2 == s.length) ? -1 : 2;
				}
			}
			System.out.println(answer);
		}
	}

	/**
	 * 入力数字の10進数の各桁の配列を計算する
	 * 
	 * @param n 入力数字
	 * @return 入力数字の10進数の各桁の配列
	 */
	private static int[] digits(long n) {
		List<Integer> list = new ArrayList<>();
		while (n > 0) {
			list.add((int) (n % 10));
			n /= 10;
		}
		return list.stream().mapToInt(Integer::intValue).toArray();
	}
}
