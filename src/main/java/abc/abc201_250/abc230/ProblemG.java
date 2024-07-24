package abc.abc201_250.abc230;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc230/editorial/3020 の実装
 */
public class ProblemG {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] p = new int[n + 1];
			p[0] = 0;
			IntStream.rangeClosed(1, n).forEach(i -> p[i] = scanner.nextInt());
			boolean[] pr = new boolean[n + 1];
			Arrays.fill(pr, true);
			pr[0] = pr[1] = false;
			int[] mu = new int[n + 1];
			Arrays.fill(mu, -1);
			mu[0] = mu[1] = 0;
			List<Integer> m = new ArrayList<>();
			@SuppressWarnings("unchecked")
			List<Integer>[] d = new List[n + 1];
			IntStream.rangeClosed(0, n).forEach(i -> d[i] = new ArrayList<>());
			IntStream.rangeClosed(2, n).forEach(i -> {
				if (pr[i]) {
					mu[i] = -mu[i];
					for (int j = i + i; j <= n; j += i) {
						pr[j] = false;
						mu[j] = (0 == ((j / i) % i)) ? 0 : -mu[j];
					}
				}
				if (0 != mu[i]) {
					m.add(i);
					for (int j = i; j <= n; j += i) {
						d[j].add(i);
					}
				}
			});
			boolean[] used = new boolean[n + 1];
			Arrays.fill(used, false);
			long[] num = new long[n + 1];
			Arrays.fill(num, 0L);
			List<Integer> cand = new ArrayList<>();
			long answer = 0L;
			for (int mi : m) {
				for (int i = mi; i <= n; i += mi) {
					for (int dpi : d[p[i]]) {
						num[dpi]++;
						if (!used[dpi]) {
							used[dpi] = true;
							cand.add(dpi);
						}
					}
				}
				for (int b : cand) {
					answer += mu[mi] * (long) mu[b] * ((num[b] * (num[b] + 1)) >> 1);
					num[b] = 0L;
					used[b] = false;
				}
				cand.clear();
			}
			System.out.println(answer);
		}
	}
}
