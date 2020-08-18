package abc175;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			int[] p = new int[n];
			IntStream.range(0, n).forEach(i -> p[i] = scanner.nextInt() - 1);
			long[] c = new long[n], scores = new long[n + 1];
			IntStream.range(0, n).forEach(i -> c[i] = scanner.nextLong());
			long max = Long.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				Set<Integer> set = new HashSet<>();
				Arrays.fill(scores, 0L);
				long score = 0L;
				int count = 0;
				int current = i;
				while ((!set.contains(current)) && (k > count)) {
					// ループを計算
					set.add(current);
					score += c[current];
					scores[++count] = score;
					current = p[current];
				}
				if ((score > 0) && (k > count)) {
					// すべてのループを回した場合の最大値を計算
					max = Math.max(max, (k / count) * score
							+ IntStream.rangeClosed(1, k % count).mapToLong(j -> scores[j]).max().orElse(0L));
					// 最後のループを回さない場合の最大値を計算
					max = Math.max(max, Math.max(0, (k / count) - 1) * score
							+ IntStream.rangeClosed(1, count).mapToLong(j -> scores[j]).max().orElse(0L));
				} else {
					max = Math.max(max, IntStream.rangeClosed(1, count).mapToLong(j -> scores[j]).max().getAsLong());
				}
			}
			System.out.println(max);
		}
	}
}
