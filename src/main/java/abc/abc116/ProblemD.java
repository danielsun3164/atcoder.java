package abc.abc116;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 * 
 * https://atcoder.jp/contests/abc116/submissions/14852322 にも参考
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			int[] t = new int[n];
			long[] d = new long[n];
			IntStream.range(0, n).forEach(i -> {
				t[i] = scanner.nextInt();
				d[i] = scanner.nextLong();
			});
			// indexをd[i]でソートする
			int[] sortedIndexes = IntStream.range(0, n).boxed().sorted((i1, i2) -> Long.compare(d[i2], d[i1]))
					.mapToInt(Integer::intValue).toArray();
			// 選択されたtを保存するセット
			Set<Integer> tSet = new HashSet<>();
			Stack<Long> extraDs = new Stack<>();
			long sum = IntStream.range(0, k).map(i -> sortedIndexes[i]).mapToLong(index -> {
				if (tSet.contains(t[index])) {
					extraDs.add(d[index]);
				} else {
					tSet.add(t[index]);
				}
				return d[index];
			}).sum();
			long max = sum + tSet.size() * (long) tSet.size();
			for (int i = k; i < n; i++) {
				int index = sortedIndexes[i];
				if (!extraDs.isEmpty() && !tSet.contains(t[index])) {
					sum += d[index] - extraDs.pop();
					tSet.add(t[index]);
					max = Math.max(max, sum + tSet.size() * (long) tSet.size());
				}
			}
			System.out.println(max);
		}
	}
}
