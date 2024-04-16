package abc.abc201_250.abc222;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	/** グーを表す文字 */
	private static final char GUH = 'G';
	/** チョキを表す文字 */
	private static final char CHOKI = 'C';
	/** パーを表す文字 */
	private static final char PAH = 'P';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt() << 1, m = scanner.nextInt();
			char[][] a = IntStream.range(0, n).mapToObj(i -> scanner.next().toCharArray()).toArray(char[][]::new);
			// 勝利数を保管する配列と順番を保存する配列
			int[] counts = new int[n];
			Integer[] ranks = IntStream.range(0, n).boxed().toArray(Integer[]::new);
			IntStream.range(0, m).forEach(i -> {
				IntStream.range(0, n >> 1).forEach(j -> process(i, j, ranks, counts, a));
				Arrays.sort(ranks, (x, y) -> (counts[x] == counts[y]) ? Integer.compare(x, y)
						: Integer.compare(counts[y], counts[x]));
			});
			Arrays.stream(ranks).mapToInt(Integer::intValue).map(i -> i + 1).forEach(System.out::println);
		}
	}

	/**
	 * iラウンド目のk組の試合を行う
	 *
	 * @param i      ラウンド
	 * @param k      組
	 * @param ranks  ランク順の配列
	 * @param counts 勝利数の配列
	 * @param a      試合で出す手の配列
	 */
	private static void process(int i, int k, Integer[] ranks, int[] counts, char[][] a) {
		int p1 = ranks[k << 1], p2 = ranks[(k << 1) + 1];
		char t1 = a[p1][i], t2 = a[p2][i];
		if (t1 == t2) {
			return;
		}
		if (GUH == t1) {
			if (PAH == t2) {
				counts[p2]++;
			} else {
				counts[p1]++;
			}
		} else if (CHOKI == t1) {
			if (PAH == t2) {
				counts[p1]++;
			} else {
				counts[p2]++;
			}
		} else {
			// t1==PAH
			if (GUH == t2) {
				counts[p1]++;
			} else {
				counts[p2]++;
			}
		}
	}
}
