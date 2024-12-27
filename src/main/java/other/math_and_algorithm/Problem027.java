package other.math_and_algorithm;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem027 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray(), c = new int[n];
			mergeSort(a, c, 0, n);
			System.out.println(Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
		}
	}

	/**
	 * 配列aの[l,r)の範囲に対して、マージソートを実施する
	 *
	 * @param a ソート対象配列
	 * @param c 一時配列
	 * @param l 開始インデックス(含む)
	 * @param r 終了インデックス(含まない)
	 */
	private static void mergeSort(int[] a, int[] c, int l, int r) {
		if (1 == r - l) {
			c[l] = a[l];
			return;
		}
		int m = (r - l) / 2 + l;
		mergeSort(a, c, l, m);
		mergeSort(a, c, m, r);
		System.arraycopy(a, l, c, l, r - l);
		int index1 = l, index2 = m;
		for (int i = l; i < r; i++) {
			if (m == index1) {
				a[i] = c[index2++];
			} else if ((r == index2) || (c[index1] <= c[index2])) {
				a[i] = c[index1++];
			} else {
				a[i] = c[index2++];
			}
		}
	}
}
