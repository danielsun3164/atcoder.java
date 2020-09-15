package abc.abc102;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt() - 1 - i).sorted().toArray();
			// 中央値を求める
			int middle = (0 == (1 & n)) ? (a[n / 2] + a[n / 2 - 1]) / 2 : a[n / 2];
			System.out.println(IntStream.range(0, n).mapToLong(i -> Math.abs(a[i] - middle)).sum());
		}
	}
}
