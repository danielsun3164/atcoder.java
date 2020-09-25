package abc.abc127;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * imos法の回答
 */
public class ProblemC別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[] count = new int[n + 1];
			Arrays.fill(count, 0);
			IntStream.range(0, m).forEach(i -> {
				count[scanner.nextInt() - 1]++;
				count[scanner.nextInt()]--;
			});
			IntStream.rangeClosed(1, n).forEach(i -> count[i] += count[i - 1]);
			System.out.println(IntStream.range(0, n).filter(i -> m == count[i]).count());
		}
	}
}
