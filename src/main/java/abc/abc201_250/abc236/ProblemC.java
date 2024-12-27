package abc.abc201_250.abc236;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			String[] s = IntStream.range(0, n).mapToObj(i -> scanner.next()).toArray(String[]::new);
			Set<String> t = IntStream.range(0, m).mapToObj(i -> scanner.next()).collect(Collectors.toSet());
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			Arrays.stream(s).forEach(si -> sb.append(t.contains(si) ? "Yes" : "No").append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
