package abc.abc101_150.abc143;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 累積和の実装
 *
 * https://atcoder.jp/contests/abc143/submissions/8031606 にも参考
 */
public class ProblemD別回答2 {

	/** 入力数字最大値の2倍 */
	private static final int N = 2_005;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] c = new int[N], s = new int[N];
			Arrays.fill(c, 0);
			int maxL = IntStream.range(0, n).map(i -> {
				int l = scanner.nextInt();
				c[l]++;
				return l;
			}).max().getAsInt();
			s[0] = 0;
			IntStream.range(1, N).forEach(i -> s[i] = s[i - 1] + c[i]);
			System.out.println(IntStream.rangeClosed(1, maxL).filter(i -> c[i] > 0).mapToLong(i -> {
				long answer = IntStream.rangeClosed(i + 1, maxL).filter(j -> c[j] > 0)
						.mapToLong(j -> c[i] * c[j] * (s[i + j - 1] - s[j])).sum();
				answer += c[i] * (long) (c[i] - 1) / 2 * (s[i + i - 1] - s[i]);
				answer += c[i] * (long) (c[i] - 1) / 2 * s[i - 1];
				answer += c[i] * (long) (c[i] - 1) / 2 * (c[i] - 2) / 3;
				return answer;
			}).sum());
		}
	}
}
