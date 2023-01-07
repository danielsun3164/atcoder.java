package other.typical90;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem016 {

	/** 硬貨の種類数 */
	private static final int N = 3;
	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = IntStream.range(0, N).map(i -> scanner.nextInt()).sorted().toArray();
			System.out.println(IntStream.rangeClosed(0, n / a[2]).map(i -> i + check(a[0], a[1], n - (i * a[2]))).min()
					.getAsInt());
		}
	}

	/**
	 * aとbのコインでnを組み合わせるための枚数を計算する
	 *
	 * @param a
	 * @param b
	 * @param n
	 * @return aとbのコインでnを組み合わせるための枚数
	 */
	private static int check(int a, int b, int n) {
		for (int i = n / b; i >= 0; i--) {
			if (0 == ((n - (i * b)) % a)) {
				return i + ((n - (i * b)) / a);
			}
		}
		return INF;
	}
}
