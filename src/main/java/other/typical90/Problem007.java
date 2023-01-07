package other.typical90;

import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class Problem007 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			NavigableSet<Integer> set = new TreeSet<>();
			IntStream.range(0, n).forEach(i -> set.add(scanner.nextInt()));
			int q = scanner.nextInt();
			// TLE回避のため、結果をStringBuilderにまとめる
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, q).forEach(i -> {
				int b = scanner.nextInt();
				int min = Integer.MAX_VALUE;
				Integer ceiling = set.ceiling(b);
				if (null != ceiling) {
					min = Math.min(min, Math.abs(ceiling - b));
				}
				Integer floor = set.floor(b);
				if (null != floor) {
					min = Math.min(min, Math.abs(floor - b));
				}
				sb.append(min).append(System.lineSeparator());
			});
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
