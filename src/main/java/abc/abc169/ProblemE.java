package abc.abc169;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = new int[n], b = new int[n];
			IntStream.range(0, n).forEach(i -> {
				a[i] = scanner.nextInt();
				b[i] = scanner.nextInt();
			});
			Arrays.sort(a);
			Arrays.sort(b);
			System.out.println(middle(b) - middle(a) + 1);
		}
	}

	/**
	 * 配列の中央値を計算する
	 * 
	 * <pre>
	 * 配列の個数Nが奇数のときの中央値は a[N/2]
	 * 配列の個数Nが偶数のときの中央値は a[(N-1)/2]+a[(N-1)/2+1] （本来の中央値の2倍）
	 * </pre>
	 * 
	 * @param a 配列
	 * @return 配列の中央値
	 */
	private static int middle(int[] a) {
		if (0 == (a.length & 1)) {
			return a[(a.length - 1) / 2] + a[(a.length - 1) / 2 + 1];
		} else {
			return a[a.length / 2];
		}
	}
}
