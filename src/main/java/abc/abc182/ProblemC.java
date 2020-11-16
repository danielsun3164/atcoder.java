package abc.abc182;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProblemC {

	/** 3の倍数を計算する */
	private static final int N = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			int[] s = digits(n);
			int sum = Arrays.stream(s).sum();
			if (0 == (sum % N)) {
				System.out.println(0);
				return;
			}
			if (s.length > 1) {
				for (int i = 0; i < s.length; i++) {
					if (0 == ((sum - s[i]) % N)) {
						System.out.println(1);
						return;
					}
				}
			}
			if (s.length > 2) {
				for (int i = 0; i < s.length; i++) {
					for (int j = 0; j < s.length; j++) {
						if (0 == ((sum - s[i] - s[j]) % N)) {
							System.out.println(2);
							return;
						}
					}
				}
			}
			System.out.println(-1);
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
