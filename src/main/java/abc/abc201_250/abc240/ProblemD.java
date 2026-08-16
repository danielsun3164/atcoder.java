package abc.abc201_250.abc240;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int[] value = new int[n + 1], count = new int[n + 1];
			int index = 0, result = 0;
			value[index] = -1;
			count[index] = 1;
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; i++) {
				result++;
				if (value[index] == a[i]) {
					count[index]++;
					if (count[index] == a[i]) {
						result -= a[i];
						index--;
					}
				} else {
					value[++index] = a[i];
					count[index] = 1;
				}
				sb.append(result).append(System.lineSeparator());
			}
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
