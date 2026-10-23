package abc.abc201_250.abc247;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc247/editorial/3736 の解法1尺取り法の実装
 */
public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), x = scanner.nextInt(), y = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int i = 0;
			long answer = 0L;
			while (i < n) {
				List<Integer> b = new ArrayList<>();
				while ((i < n) && (y <= a[i]) && (a[i] <= x)) {
					b.add(a[i]);
					i++;
				}
				if (!b.isEmpty()) {
					answer += calc(x, y, b);
				} else {
					i++;
				}
			}
			System.out.println(answer);
		}
	}

	/**
	 * 配列bの最大値がx，最小値がyのサブ区間の数を計算する
	 *
	 * @param b
	 * @return 配列bの最大値がx，最小値がyのサブ区間の数
	 */
	private static long calc(int x, int y, List<Integer> b) {
		int i = 0, j = 0, countX = 0, countY = 0;
		long result = 0L;
		while (i < b.size()) {
			while ((j < b.size()) && ((0 == countX) || (0 == countY))) {
				if (b.get(j).equals(x)) {
					countX++;
				}
				if (b.get(j).equals(y)) {
					countY++;
				}
				j++;
			}
			if ((countX > 0) && (countY > 0)) {
				result += b.size() + 1 - j;
			}
			if (b.get(i).equals(x)) {
				countX--;
			}
			if (b.get(i).equals(y)) {
				countY--;
			}
			i++;
		}
		return result;
	}
}
