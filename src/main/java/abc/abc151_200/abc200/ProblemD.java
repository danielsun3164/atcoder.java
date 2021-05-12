package abc.abc151_200.abc200;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemD {

	/** 200の定数 */
	private static final int N = 200;
	/** 処理する最大の数 */
	private static final int M = 8;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt() % N).toArray();
			int m = Math.min(n, M);
			int[] buffer = new int[N];
			Arrays.fill(buffer, -1);
			for (int bit = 1; bit < (1 << m); bit++) {
				int result = sum(m, a, bit);
				if (buffer[result] > 0) {
					System.out.println("Yes");
					print(buffer[result], m);
					print(bit, m);
					return;
				} else {
					buffer[result] = bit;
				}
			}
			System.out.println("No");
		}
	}

	/**
	 * 配列aの最初のm項目のbitに該当する項目の値の合計を計算する
	 *
	 * @param m
	 * @param a
	 * @param bit indexのビット表現
	 * @return 配列aの最初のm項目のbitに該当する項目の値の合計
	 */
	private static int sum(int m, int[] a, int bit) {
		return IntStream.range(0, m).filter(i -> (bit & (1 << i)) > 0).map(i -> a[i]).sum() % N;
	}

	/**
	 * bitに該当するindexの一覧を出力する
	 *
	 * @param bit indexのビット表現
	 * @param m   indexの最大値
	 */
	private static void print(int bit, int m) {
		System.out.print(Integer.bitCount(bit));
		IntStream.range(0, m).filter(i -> (bit & (1 << i)) > 0).forEach(i -> System.out.print(" " + (i + 1)));
		System.out.println();
	}
}
