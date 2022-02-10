package abc.abc151_200.abc153;

import java.util.Arrays;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long d = scanner.nextLong() * 2L, a = scanner.nextLong();
			Data[] datas = IntStream.range(0, n).mapToObj(i -> {
				long x = scanner.nextLong(), h = scanner.nextLong();
				return new Data(x, (h + a - 1) / a);
			}).sorted((x, y) -> Long.compare(x.x, y.x)).toArray(Data[]::new);
			int index = 1;
			long[] v = new long[n + 2];
			Arrays.fill(v, 0L);
			TreeMap<Long, Integer> indexMap = new TreeMap<>();
			for (Data data : datas) {
				v[index] += data.h;
				v[index + 1] -= data.h;
				indexMap.put(data.x, index);
				index++;
			}
			long answer = 0L;
			index = 1;
			for (Data data : datas) {
				v[index] += v[index - 1];
				if (v[index] > 0L) {
					answer += v[index];
					Entry<Long, Integer> entry = indexMap.higherEntry(data.x + d);
					if (null != entry) {
						v[entry.getValue()] += v[index];
					}
					v[index] = 0L;
				}
				index++;
			}
			System.out.println(answer);
		}
	}

	/**
	 * xとhを格納する
	 */
	private static class Data {
		long x, h;

		Data(long x, long h) {
			super();
			this.x = x;
			this.h = h;
		}
	}
}
