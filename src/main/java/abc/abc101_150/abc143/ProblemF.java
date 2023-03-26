package abc.abc101_150.abc143;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 *
 * 実行時間短縮のため、結果をStringBuilderで出力する
 */
public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = new int[n], c = new int[n + 1], d = new int[n + 1];
			Arrays.fill(c, 0);
			Arrays.fill(d, 0);
			IntStream.range(0, n).forEach(i -> {
				a[i] = scanner.nextInt();
				c[a[i]]++;
			});
			Arrays.stream(c).forEach(ci -> d[ci]++);
			// sumD[i]は0...i のD[k]の合計，sumKD[i] は0...iのk*D[k]の合計
			long[] sumD = new long[n + 1], sumKD = new long[n + 1];
			sumD[0] = sumKD[0] = 0L;
			IntStream.rangeClosed(1, n).forEach(i -> {
				sumD[i] = sumD[i - 1] + d[i];
				sumKD[i] = sumKD[i - 1] + i * (long) d[i];
			});
			long[] f = new long[n + 1];
			f[0] = 0L;
			IntStream.rangeClosed(1, n).forEach(i -> f[i] = (sumKD[i] + i * (sumD[n] - sumD[i])) / i);
			int index = n;
			// TLE対策のため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i <= n; i++) {
				while ((index > 0) && (f[index] < i)) {
					index--;
				}
				sb.append(index).append(System.lineSeparator());
			}
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
