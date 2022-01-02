package abc.abc151_200.abc155;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemD {

	/** 最大値 */
	private static final long INF = Long.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long k = scanner.nextLong();
			List<Long> negativeList = new ArrayList<>(), positiveList = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				long a = scanner.nextLong();
				if (a < 0L) {
					negativeList.add(a);
				} else if (a > 0L) {
					positiveList.add(a);
				}
			}
			long[] negatives = negativeList.stream().mapToLong(Long::longValue).sorted().toArray();
			long[] negatives2 = new long[negatives.length];
			IntStream.range(0, negatives.length).forEach(i -> negatives2[negatives.length - 1 - i] = -negatives[i]);
			long[] positives = positiveList.stream().mapToLong(Long::longValue).sorted().toArray();
			long ng = -INF, ok = INF;
			while (ok > ng + 1L) {
				long med = (ng + ok) / 2L;
				if (k <= getCount(n, negatives, negatives2, positives, med)) {
					ok = med;
				} else {
					ng = med;
				}
			}
			System.out.println(ok);
		}
	}

	/**
	 * 積が指定された上限値以下の組み合わせ数を計算する
	 *
	 * @param n          数字の総数
	 * @param negatives  負の数字の配列
	 * @param negatives2 負の数字を正に変換した配列
	 * @param positives  正の数字の配列
	 * @param limit      上限値
	 * @return 積が指定された上限値以下の組み合わせ数
	 */
	private static long getCount(int n, long[] negatives, long[] negatives2, long[] positives, long limit) {
		long result = getMinus(negatives, positives, limit);
		if (limit >= 0) {
			int zeroCount = n - negatives.length - positives.length;
			result += zeroCount * (zeroCount - 1L) / 2L + zeroCount * ((long) n - zeroCount);
		}
		if (limit > 0) {
			result += getPlus(negatives2, positives, limit);
		}
		return result;
	}

	/**
	 * 負の積が指定された上限値以下の組み合わせ数
	 *
	 * @param negatives 負の数字の配列
	 * @param positives 正の数字の配列
	 * @param limit     上限値
	 * @return 負の積が指定された上限値以下の組み合わせ数
	 */
	private static long getMinus(long[] negatives, long[] positives, long limit) {
		if (limit >= 0) {
			return negatives.length * (long) positives.length;
		}
		long result = 0L;
		int j = 0;
		for (long negative : negatives) {
			while ((j < positives.length) && (limit < negative * positives[j])) {
				j++;
			}
			result += positives.length - j;
		}
		return result;
	}

	/**
	 * 正の積が指定された上限値以下の組み合わせ数を計算する
	 *
	 * @param negatives2 負の数字を正に変換した配列
	 * @param positives  正の数字の配列
	 * @param limit      上限値
	 * @return 正の積が指定された上限値以下の組み合わせ数
	 */
	private static long getPlus(long[] negatives2, long[] positives, long limit) {
		return count(negatives2, limit) + count(positives, limit);
	}

	/**
	 * 配列の2つの値の積が上限値以下の組み合わせ数を計算する
	 *
	 * @param a     配列
	 * @param limit 上限値
	 * @return 配列の2つの値の積が上限値以下の組み合わせ数
	 */
	private static long count(long[] a, long limit) {
		long result = 0L;
		int n = a.length;
		int j = n - 1;
		for (int i = 0; i < n; i++) {
			while ((i < j) && (limit < a[i] * a[j])) {
				j--;
			}
			result += Math.max(0L, j - i);
		}
		return result;
	}
}
