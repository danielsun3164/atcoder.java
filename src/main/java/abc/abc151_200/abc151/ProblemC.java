package abc.abc151_200.abc151;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	/** ACの文字 */
	private static final String AC = "AC";

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			boolean[] result = new boolean[n];
			Arrays.fill(result, false);
			int[] count = new int[n], answer = new int[2];
			Arrays.fill(count, 0);
			Arrays.fill(answer, 0);
			IntStream.range(0, m).forEach(i -> {
				int p = scanner.nextInt() - 1;
				String s = scanner.next();
				if (!result[p]) {
					if (AC.equals(s)) {
						result[p] = true;
						answer[0]++;
						answer[1] += count[p];
					} else {
						count[p]++;
					}
				}
			});
			System.out.println(answer[0] + " " + answer[1]);
		}
	}
}
