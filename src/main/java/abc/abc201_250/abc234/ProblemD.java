package abc.abc201_250.abc234;

import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			NavigableSet<Integer> set = new TreeSet<>();
			IntStream.range(0, k).forEach(i -> set.add(scanner.nextInt()));
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			IntStream.range(k, n).forEach(i -> {
				sb.append(set.first()).append(System.lineSeparator());
				set.add(scanner.nextInt());
				set.pollFirst();
			});
			sb.append(set.first()).append(System.lineSeparator());
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
