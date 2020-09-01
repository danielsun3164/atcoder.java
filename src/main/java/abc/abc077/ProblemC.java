package abc.abc077;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説どおりに実装したソースコード
 * 
 * lower_boundとupper_boundの実装は https://qiita.com/taskie/items/b4e45e2005aa38e90bcb に参考
 */
public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Integer[] a = new Integer[n], b = new Integer[n], c = new Integer[n];
			IntStream.range(0, n).forEach(i -> a[i] = scanner.nextInt());
			IntStream.range(0, n).forEach(i -> b[i] = scanner.nextInt());
			IntStream.range(0, n).forEach(i -> c[i] = scanner.nextInt());
			Arrays.sort(a);
			Arrays.sort(c);
			System.out.println(
					IntStream.range(0, n).mapToLong(i -> getLessCount(b[i], a) * getGreaterCount(b[i], c)).sum());
		}
	}

	/**
	 * 配列の中で入力数字より小さい数字の数を返す
	 * 
	 * @param i 数字
	 * @param a 配列
	 * @return 配列の中で入力数字より小さい数字の数
	 */
	private static long getLessCount(int i, Integer[] a) {
		int result = Arrays.binarySearch(a, i, (x, y) -> (x.compareTo(y) >= 0) ? 1 : -1);
		if (result < 0) {
			result = ~result;
		}
		return result;
	}

	/**
	 * 配列の中で入力数字より大きい数字の数を返す
	 * 
	 * @param i 数字
	 * @param a 配列
	 * @return 配列の中で入力数字より大きい数字の数
	 */
	private static long getGreaterCount(int i, Integer[] a) {
		int result = Arrays.binarySearch(a, i, (x, y) -> (x.compareTo(y) > 0) ? 1 : -1);
		if (result < 0) {
			result = ~result;
		}
		return a.length - result;
	}
}
