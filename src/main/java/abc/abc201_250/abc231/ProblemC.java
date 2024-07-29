package abc.abc201_250.abc231;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), q = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).sorted().toArray();
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			while (q-- > 0) {
				int x = scanner.nextInt();
				int index = Arrays.binarySearch(a, x);
				sb.append(n - ((index < 0) ? ~index : index)).append(System.lineSeparator());
			}
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
