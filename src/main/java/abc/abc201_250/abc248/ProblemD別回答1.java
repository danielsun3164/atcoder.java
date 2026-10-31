package abc.abc201_250.abc248;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc248/editorial/3821 の実装<br/>
 * https://atcoder.jp/contests/abc248/submissions/31064355 にも参考
 */
public class ProblemD別回答1 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(_ -> scanner.nextInt()).toArray();
			int q = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Data>[] event = new List[n + 1];
			IntStream.rangeClosed(0, n).forEach(i -> event[i] = new ArrayList<>());
			IntStream.range(0, q).forEach(i -> {
				int l = scanner.nextInt(), r = scanner.nextInt(), x = scanner.nextInt();
				event[l - 1].add(new Data(x, i));
				event[r].add(new Data(x, i));
			});
			int[] count = new int[n + 1], answers = new int[q];
			Arrays.fill(count, 1);
			Arrays.fill(answers, 0);
			IntStream.rangeClosed(0, n).forEach(i -> {
				for (Data data : event[i]) {
					if (answers[data.index] != 0) {
						answers[data.index] += count[data.x];
					} else {
						answers[data.index] -= count[data.x];
					}
				}
				if (i < n) {
					count[a[i]]++;
				}
			});
			// TLE対策のため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			Arrays.stream(answers).forEach(ai -> sb.append(ai).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * x,indexを格納するクラス
	 */
	private static class Data {
		int x, index;

		Data(int x, int index) {
			super();
			this.x = x;
			this.index = index;
		}
	}
}
