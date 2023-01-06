package other.typical90;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem001 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), l = scanner.nextInt(), k = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int left = 0, right = l + 1;
			while (right > (left + 1)) {
				int med = (left + right) / 2;
				if (ok(n, l, k, a, med)) {
					left = med;
				} else {
					right = med;
				}
			}
			System.out.println(left);
		}
	}

	/**
	 * minの最小長さが達成できるかどうかを計算する
	 *
	 * @param n   切れ目の数
	 * @param l   ようかん全体の長さ
	 * @param k   選ばれる切れ目の数
	 * @param a   切れ目の場所の配列
	 * @param min 一切れの最小長さ
	 * @return minの最小長さが達成できるかどうか
	 */
	private static boolean ok(int n, int l, int k, int[] a, int min) {
		int now = 0, count = 0;
		for (int i = 0; i < n; i++) {
			if ((a[i] - now) >= min) {
				now = a[i];
				count++;
				if (count > k) {
					break;
				}
			}
		}
		if ((l - now) >= min) {
			count++;
		}
		return count > k;
	}
}
