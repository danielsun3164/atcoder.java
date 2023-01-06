package other.typical90;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class Problem051 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			long p = scanner.nextLong();
			long[] a = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).sorted().toArray();
			// 配列aを2つに分ける
			long[][] b = new long[2][];
			b[0] = new long[(n + 1) / 2];
			b[1] = new long[n / 2];
			IntStream.range(0, n).forEach(i -> b[i & 1][i >> 1] = a[i]);
			// それぞれcount[0、1][i]はi個の要素を選んだ合計の個数
			int[][] counts = new int[2][], indexes = new int[2][];
			IntStream.range(0, 2).forEach(i -> {
				counts[i] = new int[b[i].length + 1];
				indexes[i] = new int[b[i].length + 1];
			});
			counts[0][0] = counts[1][0] = 1;
			IntStream.range(0, 2).forEach(i -> IntStream.range(1, counts[i].length)
					.forEach(j -> counts[i][j] = counts[i][j - 1] * (b[i].length - j + 1) / j));
			IntStream.range(0, 2).forEach(i -> Arrays.fill(indexes[i], 0));
			// sum[0、1][i] はi個の要素の合計の配列
			long[][][] sum = new long[2][][];
			IntStream.range(0, 2).forEach(i -> sum[i] = new long[counts[i].length][]);
			IntStream.range(0, 2).forEach(
					i -> IntStream.range(0, counts[i].length).forEach(j -> sum[i][j] = new long[counts[i][j]]));
			IntStream.range(0, 2).forEach(i -> IntStream.range(0, 1 << b[i].length).forEach(bit -> {
				int bitCount = Integer.bitCount(bit);
				sum[i][bitCount][indexes[i][bitCount]++] = IntStream.range(0, b[i].length)
						.filter(j -> (bit & (1 << j)) > 0).mapToLong(j -> b[i][j]).sum();
			}));
			// すべてのsum[i][j]をソートする
			IntStream.range(0, 2).forEach(i -> IntStream.range(0, sum[i].length).forEach(j -> Arrays.sort(sum[i][j])));
			System.out.println(IntStream.rangeClosed(0, b[0].length)
					.filter(i -> (k - i >= 0) && (k - i < sum[1].length)).mapToLong(i -> {
						long ans = 0L;
						int index0 = 0, index1 = sum[1][k - i].length - 1;
						while ((index0 < sum[0][i].length) && (index1 >= 0)) {
							while ((index1 >= 0) && (sum[0][i][index0] + sum[1][k - i][index1] > p)) {
								index1--;
							}
							ans += index1 + 1;
							index0++;
						}
						return ans;
					}).sum());
		}
	}
}
