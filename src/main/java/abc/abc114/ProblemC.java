package abc.abc114;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説どおりに作成したソースコード
 */
public class ProblemC {

	private static final char[] BASES = new char[] { '3', '5', '7' };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String n = scanner.next();
			int answer = IntStream.range(3, n.length()).map(i -> calc(i)).sum();
			int[] number = new int[n.length()];
			Arrays.fill(number, 0);
			while (increaseNumber(number)) {
				String string = getNumber(number);
				if (string.compareTo(n) > 0) {
					break;
				} else {
					if (is753(number)) {
						answer++;
					}
				}
			}
			System.out.println(answer);
		}
	}

	/**
	 * numberで表す数字を一つ上げる
	 * 
	 * @param number
	 * @return 上げられない場合はfalse
	 */
	private static boolean increaseNumber(int[] number) {
		return increaseNumber(number, 0);
	}

	/**
	 * numberで表す数字は753数字かどうかを判定する
	 * 
	 * @param number
	 * @return numberで表す数字は753数字かどうか
	 */
	private static boolean is753(int[] number) {
		return BASES.length == Arrays.stream(number).distinct().count();
	}

	/**
	 * numberのi番目の数字を一つ上げる
	 * 
	 * @param number
	 * @param i
	 * @return 上げられない場合はfalse
	 */
	private static boolean increaseNumber(int[] number, int i) {
		if (i < number.length) {
			number[i]++;
			if (number[i] >= BASES.length) {
				number[i] = 0;
				return increaseNumber(number, i + 1);
			}
			return true;
		}
		return false;
	}

	/**
	 * n桁の七五三数の数を計算する
	 * 
	 * @param n
	 * @return n桁の七五三数の数
	 */
	private static int calc(int n) {
		return pow(3, n) - 3 * pow(2, n) + 3;
	}

	/**
	 * numberの配列から3,5,7の文字列へ変換する
	 * 
	 * @param number 配列
	 * @return 3,5,7の文字列
	 */
	private static String getNumber(int[] number) {
		StringBuilder sb = new StringBuilder();
		for (int i = number.length - 1; i >= 0; i--) {
			sb.append(BASES[number[i]]);
		}
		return sb.toString();
	}

	/**
	 * nのｍ乗を計算する
	 * 
	 * @param n
	 * @param m
	 * @return nのｍ乗
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
