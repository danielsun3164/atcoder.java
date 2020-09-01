package abc.abc035;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			// オセロのひっくり返す回数の配列
			int[] s = new int[n + 1];
			Arrays.fill(s, 0);
			int q = scanner.nextInt();
			IntStream.range(0, q).forEach(i -> {
				// l
				s[scanner.nextInt() - 1]++;
				// r
				s[scanner.nextInt()]--;
			});
			IntStream.range(1, n).forEach(i -> s[i] += s[i - 1]);
			// ひっくり返す回数が偶数なら0、奇数なら1
			IntStream.range(0, n).forEach(i -> System.out.print(s[i] & 1));
			System.out.println();
		}
	}
}
