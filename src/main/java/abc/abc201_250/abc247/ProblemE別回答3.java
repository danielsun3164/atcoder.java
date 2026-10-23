package abc.abc201_250.abc247;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc247/editorial/14521 の実装
 */
public class ProblemE別回答3 {
	private static int n, x, y;
	private static int[] a;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			n = scanner.nextInt();
			x = scanner.nextInt();
			y = scanner.nextInt();
			a = IntStream.range(0, n).map(_ -> scanner.nextInt()).toArray();
			System.out.println(f(y, x) - f(y + 1, x) - f(y, x - 1) + f(y + 1, x - 1));
		}
	}

	/**
	 * a連続部分列で、minがl以上かつmaxがr以下であるものの個数を計算する
	 *
	 * @param l 最小値
	 * @param r 最大値
	 * @return a連続部分列で、minがl以上かつmaxがr以下であるものの個数
	 */
	static long f(int l, int r) {
		long answer = 0, length = 0;
		for (int ai : a) {
			if (l <= ai && ai <= r) {
				length++;
			} else {
				answer += length * (length + 1) / 2;
				length = 0;
			}
		}
		answer += length * (length + 1) / 2;
		return answer;
	}
}
