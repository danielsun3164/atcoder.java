package abc.abc174;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			int[] a = new int[n];
			// left必ず達成できない、right必ず達成できる
			int left = 0, right = IntStream.range(0, n).map(i -> a[i] = scanner.nextInt()).max().getAsInt();
			while (right > left + 1) {
				int mid = (left + right) / 2;
				if (ok(n, k, a, mid)) {
					right = mid;
				} else {
					left = mid;
				}
			}
			System.out.println(right);
		}
	}

	/**
	 * 目標値をk回まで切ることで達成できるかを計算する
	 * 
	 * @param n      丸太の数
	 * @param k      切る回数の上限
	 * @param a      丸太の長さの配列
	 * @param target 目標値
	 * @return 目標値をk回のカットで達成できるか
	 */
	private static boolean ok(int n, int k, int[] a, int target) {
		return IntStream.range(0, n).map(i -> (a[i] + target - 1) / target - 1).sum() <= k;
	}
}
