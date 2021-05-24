package abc.abc201_250.abc202;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemE {

	/** in、out計算用グローバル変数 */
	private static int count;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Integer>[] childrens = new List[n], inNumbers = new List[n];
			IntStream.range(0, n).forEach(i -> {
				childrens[i] = new ArrayList<>();
				inNumbers[i] = new ArrayList<>();
			});
			IntStream.range(1, n).forEach(i -> {
				int p = scanner.nextInt() - 1;
				childrens[p].add(i);
			});
			int[] depths = new int[n], in = new int[n], out = new int[n];
			depths[0] = 0;
			count = 0;
			dfs(childrens, inNumbers, 0, depths, in, out);
			int q = scanner.nextInt();
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, q).forEach(i -> {
				int u = scanner.nextInt() - 1, d = scanner.nextInt();
				sb.append(lowerBound(inNumbers[d], out[u]) - lowerBound(inNumbers[d], in[u]))
						.append(System.lineSeparator());
			});
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * 現在のノードの深さ、inとoutを計算する
	 *
	 * @param childrens 子ノードの一覧
	 * @param inNumbers 各深さのin値の一覧
	 * @param now       現在の計算対象のノード
	 * @param depths    深さの一覧
	 * @param in        in値の一覧
	 * @param out       out値の一覧
	 */
	private static void dfs(List<Integer>[] childrens, List<Integer>[] inNumbers, int now, int[] depths, int[] in,
			int[] out) {
		in[now] = count++;
		inNumbers[depths[now]].add(in[now]);
		for (int next : childrens[now]) {
			depths[next] = depths[now] + 1;
			dfs(childrens, inNumbers, next, depths, in, out);
		}
		out[now] = count++;
	}

	/**
	 * 値が一覧におけるlowerBoundを計算する
	 *
	 * @param list  一覧
	 * @param value 値
	 * @return 値が一覧におけるlowerBound
	 */
	private static int lowerBound(List<Integer> list, int value) {
		int index = Collections.binarySearch(list, value);
		return (index < 0) ? ~index : index;
	}
}
