package abc.abc001_050.abc031;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemD {

	/** 個々の結果の長さの配列 */
	private static int[] lengths;

	/** 個々の結果の配列 */
	private static String[] results;

	/** 長さの上限 */
	private static final int N = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int k = scanner.nextInt(), n = scanner.nextInt();
			lengths = new int[k];
			results = new String[k];
			String[] v = new String[n], w = new String[n];
			IntStream.range(0, n).forEach(i -> {
				v[i] = scanner.next();
				w[i] = scanner.next();
			});
			for (int i = 0; i < Math.pow(N, k); i++) {
				if (calcResults(i, k, v, w)) {
					break;
				}
			}
			Arrays.stream(results).forEach(System.out::println);
		}
	}

	/**
	 * @param n 結果の各要素の長さ
	 * @param k 結果の数
	 * @param v 変換前の文字列の配列
	 * @param w 変換後の文字列の配列
	 * @return 変換可能かどうか
	 */
	private static boolean calcResults(final int n, final int k, final String[] v, final String[] w) {
		// 長さチェックが可能でない場合、可能でない
		if (!checkLengths(n, k, v, w)) {
			return false;
		}
		Arrays.fill(results, null);
		for (int i = 0; i < v.length; i++) {
			int wIndex = 0;
			for (int j = 0; j < v[i].length(); j++) {
				int number = v[i].charAt(j) - '1';
				String result = w[i].substring(wIndex, wIndex + lengths[number]);
				if (null == results[number]) {
					results[number] = result;
				} else if (!results[number].equals(result)) {
					return false;
				}
				wIndex += lengths[number];
			}
		}
		return true;
	}

	/**
	 * @param n 結果の各要素の長さ
	 * @param k 結果の数
	 * @param v 変換前の文字列の配列
	 * @param w 変換後の文字列の配列
	 * @return nの長さで変換可能かどうか
	 */
	private static boolean checkLengths(final int n, final int k, final String[] v, final String[] w) {
		calcLengths(n, k);
		for (int i = 0; i < v.length; i++) {
			String vi = v[i];
			if (w[i].length() != IntStream.range(0, vi.length()).map(j -> lengths[vi.charAt(j) - '1']).sum()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 結果の各要素の長さを計算する
	 * 
	 * @param n 結果の各要素の長さの元データ
	 * @param k 結果の数
	 */
	private static void calcLengths(int n, final int k) {
		for (int i = 0; i < k; i++) {
			lengths[i] = n % N + 1;
			n /= N;
		}
	}
}
