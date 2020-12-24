package abc.abc001_050.abc023;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemD {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] h = new int[n], s = new int[n];
			IntStream.range(0, n).forEach(i -> {
				h[i] = scanner.nextInt();
				s[i] = scanner.nextInt();
			});
			// 最小値はhの最大値
			long min = Arrays.stream(h).max().getAsInt();
			// 最大値はh＋n x sの最大値
			long max = IntStream.range(0, n).mapToLong(i -> h[i] + (long) n * s[i]).max().getAsLong();
			System.out.println(getResult(min, max, n, h, s, Status.UNKNOWN));
		}
	}

	/**
	 * @param min       最小値
	 * @param max       最大値（最大値は得点として可能）
	 * @param n         風船の数
	 * @param h         風船の初期位置の配列
	 * @param s         風船の上昇速度の配列
	 * @param minStatus 最小値の状態 （可能、不可能、未知の3種類）
	 * @return 最小値と最大値の間、得点の最小値
	 */
	private static long getResult(long min, long max, final int n, final int[] h, final int[] s, Status minStatus) {
		// maxとminが1しか違わない場合
		if (1L == max - min) {
			switch (minStatus) {
			case OK:
				return min;
			case NG:
				return max;
			case UNKNOWN:
			default:
				if (isPossible(min, n, h, s)) {
					return min;
				} else {
					return max;
				}
			}
		}
		long middle = (min + max) / 2L;
		if (isPossible(middle, n, h, s)) {
			return getResult(min, middle, n, h, s, minStatus);
		} else {
			return getResult(middle, max, n, h, s, Status.NG);
		}
	}

	/**
	 * https://atcoder.jp/contests/abc023/submissions/5315101 を参考に作成
	 * 
	 * @param result
	 * @param n      風船の数
	 * @param h      風船の初期位置の配列
	 * @param s      風船の上昇速度の配列
	 * @return resultが得点として可能かどうか
	 */
	private static boolean isPossible(long result, final int n, final int[] h, final int[] s) {
		// 得点がresultのとき、それぞれの風船の割れる最大時間数
		long[] t = new long[n];
		for (int i = 0; i < n; i++) {
			if (h[i] > result) {
				return false;
			}
			t[i] = (result - h[i]) / s[i];
		}
		Arrays.sort(t);
		for (int i = 0; i < n; i++) {
			if (t[i] < i) {
				return false;
			}
		}
		return true;
	}

	/**
	 * ステータス一覧
	 */
	private static enum Status {
		OK, NG, UNKNOWN
	}
}
