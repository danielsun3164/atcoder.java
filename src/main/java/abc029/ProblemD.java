package abc029;

import java.util.Scanner;

public class ProblemD {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String s = scanner.nextLine();
			System.out.println(getResult(s));
		}
	}

	/**
	 * @param s 数字nの文字列
	 * @return 1~nまでのすべての数字の中で1の数
	 */
	private static int getResult(String s) {
		if (1 == s.length()) {
			// 1桁数字の場合
			return ("0".equals(s)) ? 0 : 1;
		}
		// sの最初の数字
		int first = Integer.valueOf(s.substring(0, 1));
		// sの残りの数字
		String remain = s.substring(1);
		return getResult(first, remain);
	}

	/**
	 * @param first  nの最初の数字
	 * @param remain nの2桁以降の数字の文字列
	 * @return 1~nまでのすべての数字の中で1の数
	 */
	private static int getResult(int first, String remain) {
		if (0 == first) {
			return getResult(remain);
		}
		int sum = 0;
		sum += first * getDigitResult(remain.length()) + 1;
		if (1 == first) {
			sum += Integer.parseInt(remain);
		} else {
			sum += pow(10, remain.length()) - 1;
		}
		return sum + getResult(remain);
	}

	/**
	 * @param digit
	 * @return 0〜digit桁の9までの数字の中で含まれる1の数
	 */
	private static int getDigitResult(int digit) {
		return digit * pow(10, digit - 1);
	}

	/**
	 * @param n
	 * @param m
	 * @return nのm乗
	 */
	private static int pow(int n, int m) {
		int result = 1;
		while (m > 0) {
			if (1 == (m & 1)) {
				result *= n;
			}
			n *= n;
			m >>= 1;
		}
		return result;
	}

}
