package other.typical90;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem011 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Data[] datas = IntStream.range(0, n)
					.mapToObj(i -> new Data(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()))
					.sorted((a, b) -> Integer.compare(a.d, b.d)).toArray(Data[]::new);
			int maxD = IntStream.range(0, n).map(i -> datas[i].d).max().getAsInt();
			long[] dp = new long[maxD + 1];
			Arrays.fill(dp, 0L);
			IntStream.range(0, n).forEach(i -> {
				// d から c へ降順でループする
				IntStream.rangeClosed(datas[i].c, datas[i].d).map(j -> (datas[i].d + datas[i].c) - j)
						.forEach(j -> dp[j] = Math.max(dp[j], dp[j - datas[i].c] + datas[i].s));
			});
			System.out.println(Arrays.stream(dp).max().getAsLong());
		}
	}

	/**
	 * d,c,sを格納するクラス
	 */
	private static class Data {
		int d, c, s;

		public Data(int d, int c, int s) {
			this.d = d;
			this.c = c;
			this.s = s;
		}
	}
}
