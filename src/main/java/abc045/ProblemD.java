package abc045;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通り実装したソースコード
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt();
			int w = scanner.nextInt();
			int n = scanner.nextInt();
			Map<Dimesion, Integer> map = new HashMap<>();
			IntStream.range(0, n).forEach(i -> {
				int a = scanner.nextInt();
				int b = scanner.nextInt();
				IntStream.rangeClosed(0, 2).filter(j -> (a - j > 0) && (a - j <= h - 2)).forEach(
						j -> IntStream.rangeClosed(0, 2).filter(k -> (b - k > 0) && (b - k <= w - 2)).forEach(k -> {
							Dimesion key = new Dimesion(a - j, b - k);
							map.put(key, map.getOrDefault(key, 0) + 1);
						}));
			});
			long[] results = new long[10];
			map.values().forEach(value -> results[value]++);
			results[0] = (h - 2L) * (w - 2L) - map.size();
			Arrays.stream(results).forEach(System.out::println);
		}
	}

	/**
	 * Mapのキーとなるクラス
	 */
	private static class Dimesion {
		int x;
		int y;

		Dimesion(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Dimesion other = (Dimesion) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
	}
}
