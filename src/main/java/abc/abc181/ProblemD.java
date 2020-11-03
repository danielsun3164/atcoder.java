package abc.abc181;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemD {

	/** 0〜9の数字の数 */
	private static final int N = 10;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			if (1 == s.length) {
				if ('8' == s[0]) {
					System.out.println("Yes");
					return;
				}
			} else if (2 == s.length) {
				if ((0 == (7 & Integer.parseInt("" + s[0] + s[1])))
						|| (0 == (7 & Integer.parseInt("" + s[1] + s[0])))) {
					System.out.println("Yes");
					return;
				}
			} else {
				int[] m = new int[N];
				Arrays.fill(m, 0);
				for (char c : s) {
					m[c - '0']++;
				}
				for (int i = 1000; i < 2000; i += 8) {
					if (contains(m, i)) {
						System.out.println("Yes");
						return;
					}
				}
			}
			System.out.println("No");
		}
	}

	/**
	 * 入力文字の分布から与えた8の倍数に組合せできるかを計算する
	 * 
	 * @param m 入力文字の分布
	 * @param n 8の倍数
	 * @return 入力文字の分布から与えた8の倍数に組合せできるか
	 */
	private static boolean contains(int[] m, int n) {
		int[] counts = new int[N];
		Arrays.fill(counts, 0);
		for (int i = 0; i < 3; i++) {
			counts[n % N]++;
			n /= N;
		}
		for (int i = 0; i < 10; i++) {
			if (m[i] < counts[i]) {
				return false;
			}
		}
		return true;
	}
}
