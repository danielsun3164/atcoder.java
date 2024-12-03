package abc.abc201_250.abc237;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt();
			int[][] a = new int[h][w];
			IntStream.range(0, h).forEach(i -> a[i] = IntStream.range(0, w).map(j -> scanner.nextInt()).toArray());
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, w).forEach(i -> sb.append(
					IntStream.range(0, h).mapToObj(j -> String.valueOf(a[j][i])).collect(Collectors.joining(" ")))
					.append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
