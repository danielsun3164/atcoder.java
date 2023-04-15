package abc.abc201_250.abc218;

import java.util.NavigableSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc218/editorial/2602 解法1 貪欲法の実装
 */
public class ProblemH {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), r = scanner.nextInt();
			r = Math.min(r, n - r);
			long[] a = new long[n + 1], b = new long[n + 1];
			a[0] = a[n] = b[0] = 0L;
			NavigableSet<Data> valueSet = new TreeSet<>((x,
					y) -> (x.value == y.value) ? Integer.compare(x.index, y.index) : Long.compare(x.value, y.value)),
					indexSet = new TreeSet<>((x, y) -> Integer.compare(x.index, y.index));
			IntStream.range(1, n).forEach(i -> a[i] = scanner.nextLong());
			IntStream.rangeClosed(1, n).forEach(i -> {
				b[i] = a[i - 1] + a[i];
				Data data = new Data(i, b[i]);
				valueSet.add(data);
				indexSet.add(data);
			});
			System.out.println(IntStream.range(0, r).mapToLong(i -> {
				Data now = valueSet.pollLast();
				indexSet.remove(now);
				Data prev = indexSet.lower(now), next = indexSet.higher(now);
				if (null == prev) {
					valueSet.remove(next);
					indexSet.remove(next);
				} else if (null == next) {
					valueSet.remove(prev);
					indexSet.remove(prev);
				} else {
					valueSet.remove(prev);
					indexSet.remove(prev);
					valueSet.remove(next);
					indexSet.remove(next);
					Data nNow = new Data(now.index, prev.value - now.value + next.value);
					valueSet.add(nNow);
					indexSet.add(nNow);
				}
				return now.value;
			}).sum());
		}
	}

	/**
	 * index, valueを格納するクラス
	 */
	private static class Data {
		int index;
		long value;

		Data(int index, long value) {
			super();
			this.index = index;
			this.value = value;
		}

		@Override
		public int hashCode() {
			return Objects.hash(index, value);
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Data) {
				Data data = (Data) obj;
				return (index == data.index) && (value == data.value);
			}
			return false;
		}
	}
}
