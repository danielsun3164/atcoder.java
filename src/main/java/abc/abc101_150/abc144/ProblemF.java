package abc.abc101_150.abc144;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 *
 * https://atcoder.jp/contests/abc144/submissions/8133816 にも参考
 */
public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Integer>[] edges = new List[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, m).forEach(i -> {
				int s = scanner.nextInt() - 1, t = scanner.nextInt() - 1;
				edges[s].add(t);
			});
			System.out.println(IntStream.range(0, n - 1).mapToDouble(i -> {
				double[] e = new double[n];
				Arrays.fill(e, 1.0d);
				e[n - 1] = 0.0d;
				for (int j = n - 2; j >= 0; j--) {
					int num = edges[j].size() - (((j == i) && (edges[i].size() > 1)) ? 1 : 0);
					double maxE = 0.0;
					for (Integer next : edges[j]) {
						e[j] += 1.0d / num * e[next];
						if ((j == i) && (edges[i].size() > 1) && (e[next] > maxE)) {
							maxE = e[next];
						}
					}
					if ((j == i) && (edges[i].size() > 1)) {
						e[j] -= 1.0d / num * maxE;
					}
				}
				return e[0];
			}).min().getAsDouble());
		}
	}
}
