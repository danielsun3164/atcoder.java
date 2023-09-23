package abc.abc201_250.abc205;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), q = scanner.nextInt();
			long[] a = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).toArray();
			TreeMap<Long, Long> map = new TreeMap<>();
			long pre = -1;
			for (int i = 0; i < n; i++) {
				if (a[i] > (pre + 1)) {
					map.put(a[i] - 1 - i, a[i] - 1);
					if (i > 0) {
						map.put((a[i - 1] + 1) - i, a[i - 1] + 1);
					}
				}
				pre = a[i];
			}
			map.put((pre + 1) - n, (pre + 1));
			// TLE対策のため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, q).forEach(i -> {
				long k = scanner.nextLong();
				if (k <= map.firstKey()) {
					sb.append(k);
				} else if (k >= map.lastKey()) {
					sb.append(k + n);
				} else {
					Long floorKey = map.floorKey(k);
					if (null == floorKey) {
						sb.append(k);
					} else {
						sb.append(map.get(floorKey) + (k - floorKey));
					}
				}
				sb.append(System.lineSeparator());
			});
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
