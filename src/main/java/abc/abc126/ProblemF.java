package abc.abc126;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int m = scanner.nextInt(), k = scanner.nextInt();
			if (((m <= 1) && (0 != k)) || (k >= (1 << m))) {
				// mが0か1のとき、kは0以外、あるいは kは2^m以上
				System.out.println(-1);
				return;
			}
			int max = 1 << m;
			int[] result = new int[max << 1];
			if ((1 == m) && (0 == k)) {
				result[0] = result[1] = 0;
				result[2] = result[3] = 1;
			} else {
				IntStream.range(0, k).forEach(i -> result[i] = result[(max << 1) - i - 2] = i);
				IntStream.range(k + 1, max).forEach(i -> result[i - 1] = result[(max << 1) - i - 1] = i);
				result[max - 1] = result[(max << 1) - 1] = k;
			}
			System.out.println(Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
		}
	}
}
