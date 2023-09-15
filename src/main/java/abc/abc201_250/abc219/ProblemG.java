package abc.abc201_250.abc219;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc219/submissions/33503435 にも参考
 */
public class ProblemG {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt(), q = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Integer>[] edges = new List[n], edges2 = new List[n];
			IntStream.range(0, n).forEach(i -> {
				edges[i] = new ArrayList<>();
				edges2[i] = new ArrayList<>();
			});
			IntStream.range(0, m).forEach(i -> {
				int u = scanner.nextInt() - 1, v = scanner.nextInt() - 1;
				edges[u].add(v);
				edges[v].add(u);
			});
			int b = (int) Math.sqrt(m << 1);
			IntStream.range(0, n).forEach(
					i -> edges[i].stream().filter(ei -> edges[ei].size() >= b).forEach(ei -> edges2[i].add(ei)));
			Data[] a = new Data[n], p = new Data[n];
			IntStream.range(0, n).forEach(i -> {
				a[i] = new Data(0, i + 1);
				p[i] = new Data(-1, -1);
			});
			IntStream.rangeClosed(1, q).forEach(i -> {
				int x = scanner.nextInt() - 1;
				edges2[x].stream().forEach(j -> a[x] = max(a[x], p[j]));
				a[x].index = i;
				if (edges[x].size() < b) {
					edges[x].stream().forEach(next -> a[next] = new Data(i + 1, a[x].value));
				} else {
					p[x] = a[x];
				}
			});
			System.out.println(IntStream.range(0, n).map(i -> {
				edges2[i].stream().forEach(j -> a[i] = max(a[i], p[j]));
				return a[i].value;
			}).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
		}
	}

	/**
	 * data1とdata2との最大値を返す
	 *
	 * @param data1
	 * @param data2
	 * @return data1とdata2との最大値
	 */
	private static Data max(Data data1, Data data2) {
		if (data1.index == data2.index) {
			return (data1.value > data2.value) ? data1 : data2;
		} else {
			return (data1.index > data2.index) ? data1 : data2;
		}
	}

	/**
	 * index, valueを格納するクラス
	 */
	private static class Data {
		int index, value;

		Data(int index, int value) {
			super();
			this.index = index;
			this.value = value;
		}
	}
}
