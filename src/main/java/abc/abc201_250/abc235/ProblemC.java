package abc.abc201_250.abc235;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), q = scanner.nextInt();
			Map<Integer, List<Integer>> map = new HashMap<>();
			IntStream.range(0, n).forEach(i -> {
				int a = scanner.nextInt();
				if (!map.containsKey(a)) {
					map.put(a, new ArrayList<>());
				}
				map.get(a).add(i + 1);
			});
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			while (q-- > 0) {
				int x = scanner.nextInt(), k = scanner.nextInt() - 1;
				if (map.containsKey(x) && map.get(x).size() > k) {
					sb.append(map.get(x).get(k)).append(System.lineSeparator());
				} else {
					sb.append(-1).append(System.lineSeparator());
				}
			}
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
