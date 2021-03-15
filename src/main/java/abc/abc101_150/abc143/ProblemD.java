package abc.abc101_150.abc143;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 *
 * https://atcoder.jp/contests/abc143/submissions/19848987 にも参考
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Integer[] l = IntStream.range(0, n).map(i -> scanner.nextInt()).sorted().boxed().toArray(Integer[]::new);
			System.out.println(IntStream.range(0, n - 1)
					.map(i -> IntStream.range(i + 1, n).map(j -> lowerBound(l, l[i] + l[j]) - j).sum()).sum());
		}
	}

	/**
	 * 数字の配列lにおけるiより小さいものの最大のindexを返す
	 *
	 * @param l 数字の配列
	 * @param i 検索対象
	 * @return 数字の配列lにおけるiより小さいものの最大のindex
	 */
	private static int lowerBound(Integer[] l, Integer i) {
		int index = Arrays.binarySearch(l, i, (a, b) -> {
			int compareTo = a.compareTo(b);
			return (0 == compareTo) ? 1 : compareTo;
		});
		return ~index - 1;
	}
}
