package abc.abc201_250.abc245;

import java.util.Arrays;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc245/editorial/3635 の実装<br/>
 * https://atcoder.jp/contests/abc245/submissions/30409086 にも参考
 */
public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray(),
					b = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			Data[] datas = new Data[n + m];
			IntStream.range(0, n).forEach(i -> datas[i] = new Data(a[i], b[i], 1));
			int[] c = IntStream.range(0, m).map(i -> scanner.nextInt()).toArray(),
					d = IntStream.range(0, m).map(i -> scanner.nextInt()).toArray();
			IntStream.range(0, m).forEach(i -> datas[i + n] = new Data(c[i], d[i], 0));
			Arrays.sort(datas, (p, q) -> (p.y == q.y) ? Integer.compare(p.c, q.c) : Integer.compare(q.y, p.y));
			NavigableMap<Integer, Integer> map = new TreeMap<>();
			for (Data data : datas) {
				if (1 == data.c) {
					Entry<Integer, Integer> entry = map.ceilingEntry(data.x);
					if (null == entry) {
						System.out.println("No");
						return;
					}
					if (1 == entry.getValue()) {
						map.remove(entry.getKey());
					} else {
						map.put(entry.getKey(), entry.getValue() - 1);
					}
				} else {
					map.put(data.x, map.getOrDefault(data.x, 0) + 1);
				}
			}
			System.out.println("Yes");
		}
	}

	/**
	 * x,y,cを格納するクラス
	 */
	private static class Data {
		int x, y, c;

		Data(int x, int y, int c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}
}
