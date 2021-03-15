package abc.abc101_150.abc143;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * https://drken1215.hatenablog.com/entry/2019/10/20/032700 の解法2：しゃくとり法の実装
 */
public class ProblemD別回答1 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Integer[] l = IntStream.range(0, n).map(i -> scanner.nextInt()).sorted().boxed().toArray(Integer[]::new);
			System.out.println(IntStream.range(0, n - 1).map(i -> {
				int k = i, count = 0;
				for (int j = i + 1; j < n; j++) {
					while ((k < n) && (l[k] < l[i] + l[j])) {
						k++;
					}
					count += k - (j + 1);
				}
				return count;
			}).sum());
		}
	}
}
