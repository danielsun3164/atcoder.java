package abc.abc201_250.abc245;

import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://drken1215.hatenablog.com/entry/2022/03/30/003800 の実装
 */
public class ProblemE別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray(),
					b = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			Data[] choko = IntStream.range(0, n).mapToObj(i -> new Data(a[i], b[i])).sorted().toArray(Data[]::new);
			int[] c = IntStream.range(0, m).map(i -> scanner.nextInt()).toArray(),
					d = IntStream.range(0, m).map(i -> scanner.nextInt()).toArray();
			Data[] box = IntStream.range(0, m).mapToObj(i -> new Data(c[i], d[i])).sorted().toArray(Data[]::new);
			NavigableMap<Integer, Integer> map = new TreeMap<>();
			int result = 0, i = 0;
			for (int j = 0; j < m; j++) {
				while ((i < n) && (choko[i].x <= box[j].x)) {
					map.put(choko[i].y, map.getOrDefault(choko[i].y, 0) + 1);
					i++;
				}
				if (!map.isEmpty()) {
					Entry<Integer, Integer> entry = map.floorEntry(box[j].y);
					if (null != entry) {
						if (1 == entry.getValue()) {
							map.remove(entry.getKey());
						} else {
							map.put(entry.getKey(), entry.getValue() - 1);
						}
						result++;
					}
				}
			}
			System.out.println((n == result) ? "Yes" : "No");
		}
	}

	/**
	 * x,yを格納するクラス
	 */
	private static class Data implements Comparable<Data> {
		int x, y;

		Data(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Data o) {
			return (x == o.x) ? Integer.compare(y, o.y) : Integer.compare(x, o.x);
		}
	}
}
