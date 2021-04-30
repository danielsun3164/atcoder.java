package abc.abc151_200.abc193;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	/** 数字の種類（0〜9） */
	private static final int N = 10;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int k = scanner.nextInt();
			char[] s = scanner.next().toCharArray(), t = scanner.next().toCharArray();
			// countsは残りのカードの分布、sCountsはsのカードの分布、tCountsはtのカードの分布
			int[] counts = new int[N], sCounts = new int[N], tCounts = new int[N];
			int sum = 9 * k - 8;
			Arrays.fill(counts, k);
			IntStream.range(0, 4).forEach(i -> {
				counts[s[i] - '0']--;
				counts[t[i] - '0']--;
				sCounts[s[i] - '0']++;
				tCounts[t[i] - '0']++;
			});
			System.out.println(IntStream.range(1, N).filter(i -> counts[i] > 0).mapToDouble(i -> {
				// sがiの確率
				double sp = counts[i] * 1.0d / sum;
				sCounts[i]++;
				counts[i]--;
				double iResult = IntStream.range(1, N).filter(j -> counts[j] > 0).mapToDouble(j -> {
					// tがjの確率
					double tp = counts[j] * 1.0d / (sum - 1);
					tCounts[j]++;
					double jResult = (calc(sCounts) > calc(tCounts)) ? sp * tp : 0.0d;
					tCounts[j]--;
					return jResult;
				}).sum();
				counts[i]++;
				sCounts[i]--;
				return iResult;
			}).sum());
		}
	}

	/**
	 * カードの分布で点数を計算する
	 * 
	 * @param counts カードの分布
	 * @return 点数
	 */
	private static int calc(int[] counts) {
		return IntStream.range(1, 10).map(i -> i * ((int) Math.pow(10, counts[i]))).sum();
	}
}
