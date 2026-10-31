package abc.abc201_250.abc248;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc248/editorial/3819 の実装
 */
public class ProblemD別回答2 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			@SuppressWarnings("unchecked")
			Map<Integer, Integer>[] segmentTree = new Map[n << 1];
			IntStream.range(0, n << 1).forEach(i -> segmentTree[i] = new HashMap<>());
			IntStream.range(0, n).forEach(i -> {
				int a = scanner.nextInt();
				segmentTree[i + n].put(a, 1);
			});
			IntStream.iterate(n - 1, i -> i > 0, i -> i - 1).forEach(i -> {
				segmentTree[2 * i].entrySet().forEach(entry -> segmentTree[i].put(entry.getKey(),
						segmentTree[i].getOrDefault(entry.getKey(), 0) + entry.getValue()));
				segmentTree[2 * i + 1].entrySet().forEach(entry -> segmentTree[i].put(entry.getKey(),
						segmentTree[i].getOrDefault(entry.getKey(), 0) + entry.getValue()));
			});
			int q = scanner.nextInt();
			// TLE対策のため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			while (q-- > 0) {
				int l = scanner.nextInt() + n - 1, r = scanner.nextInt() + n, x = scanner.nextInt(), answer = 0;
				while (l != r) {
					if (1 == (1 & l)) {
						answer += segmentTree[l].getOrDefault(x, 0);
						l++;
					}
					if (1 == (1 & r)) {
						r--;
						answer += segmentTree[r].getOrDefault(x, 0);
					}
					l >>= 1;
					r >>= 1;
				}
				sb.append(answer).append(System.lineSeparator());
			}
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
