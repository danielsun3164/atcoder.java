package abc.abc201_250.abc248;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Map<Integer, List<Integer>> map = new HashMap<>();
			IntStream.rangeClosed(1, n).forEach(i -> {
				int a = scanner.nextInt();
				map.putIfAbsent(a, new ArrayList<>());
				map.get(a).add(i);
			});
			int q = scanner.nextInt();
			// TLE対策のため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			while (q-- > 0) {
				int l = scanner.nextInt(), r = scanner.nextInt(), x = scanner.nextInt();
				List<Integer> list = map.get(x);
				if (null != list) {
					sb.append(~Collections.binarySearch(list, r, (a, b) -> (a.compareTo(b) > 0) ? 1 : -1)
							- ~Collections.binarySearch(list, l, (a, b) -> (a.compareTo(b) >= 0) ? 1 : -1))
							.append(System.lineSeparator());
				} else {
					sb.append(0).append(System.lineSeparator());
				}
			}
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
