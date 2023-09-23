package abc.abc101_150.abc108;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int l = scanner.nextInt(), r = 0;
			while ((1 << (r + 1)) <= l) {
				r++;
			}
			int n = r + 1, count = 2 * r;
			// TLE対策のため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			for (int i = r; i >= 1; i--) {
				if ((l - (1 << (i - 1))) >= (1 << r)) {
					l -= 1 << (i - 1);
					sb.append(i + " " + n + " " + l).append(System.lineSeparator());
					count++;
				}
			}
			System.out.println(n + " " + count);
			IntStream.rangeClosed(1, r).forEach(i -> {
				System.out.println(i + " " + (i + 1) + " 0");
				System.out.println(i + " " + (i + 1) + " " + (1 << (i - 1)));
			});
			System.out.print(sb.toString());
		}
	}
}
