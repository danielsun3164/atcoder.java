package abc.abc201_250.abc219;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] x = scanner.next().toCharArray();
			Map<Character, Integer> map = new HashMap<>();
			IntStream.range(0, x.length).forEach(i -> map.put(x[i], i));
			int n = scanner.nextInt();
			char[][] s = new char[n][];
			IntStream.range(0, n).forEach(i -> s[i] = scanner.next().toCharArray());
			Arrays.sort(s, (a, b) -> {
				int i = 0;
				while ((i < a.length) && (i < b.length)) {
					if (a[i] == b[i]) {
						i++;
						continue;
					}
					return map.get(a[i]).compareTo(map.get(b[i]));
				}
				if (a.length == b.length) {
					return 0;
				} else {
					return (a.length == i) ? -1 : 1;
				}
			});
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			Arrays.stream(s).forEach(si -> sb.append(si).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
