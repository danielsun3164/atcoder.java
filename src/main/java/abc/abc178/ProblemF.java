package abc.abc178;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			// aに出現するiの値の個数をc[i]、bに出現するiの値の個数をd[i]
			int[] c = new int[n + 1], d = new int[n + 1];
			Arrays.fill(c, 0);
			Arrays.fill(d, 0);
			// a
			IntStream.range(0, n).forEach(i -> c[scanner.nextInt()]++);
			int[] b = IntStream.range(0, n).map(i -> {
				int k = scanner.nextInt();
				d[k]++;
				return k;
			}).toArray();
			// 可能かどうかを判定
			for (int i = 1; i <= n; i++) {
				if (c[i] + d[i] > n) {
					System.out.println("No");
					return;
				}
			}
			// aに出現するi以下の値の個数をc[i]、bに出現するi以下の値の個数をd[i]
			IntStream.rangeClosed(1, n).forEach(i -> {
				c[i] += c[i - 1];
				d[i] += d[i - 1];
			});
			// bをc[i]−d[i−1] の最大値の分だけ右にずらす
			int max = IntStream.rangeClosed(1, n).map(i -> c[i] - d[i - 1]).max().getAsInt();
			int[] result = IntStream.range(0, n).map(i -> b[(i + n - max) % n]).toArray();
			System.out.println("Yes");
			System.out.println(Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
		}
	}
}
