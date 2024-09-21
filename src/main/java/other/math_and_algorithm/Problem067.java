package other.math_and_algorithm;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem067 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt();
			int[][] a = new int[h][], b = new int[h][];
			IntStream.range(0, h).forEach(i -> a[i] = IntStream.range(0, w).map(j -> scanner.nextInt()).toArray());
			int[] rowSum = IntStream.range(0, h).map(i -> IntStream.range(0, w).map(j -> a[i][j]).sum()).toArray(),
					colSum = IntStream.range(0, w).map(j -> IntStream.range(0, h).map(i -> a[i][j]).sum()).toArray();
			IntStream.range(0, h)
					.forEach(i -> b[i] = IntStream.range(0, w).map(j -> rowSum[i] + colSum[j] - a[i][j]).toArray());
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, h)
					.forEach(i -> sb
							.append(Arrays.stream(b[i]).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
							.append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
