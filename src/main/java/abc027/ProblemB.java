package abc027;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = new int[n];
			IntStream.range(0, n).forEach(i -> a[i] = scanner.nextInt());
			int sum = Arrays.stream(a).sum();
			if (0 != (sum % n)) {
				// 合計からnを割けれない場合
				System.out.println("-1");
				return;
			}
			int average = sum / n;
			System.out.println(calcResult(a, 0, n - 1, average));
		}
	}

	/**
	 * @param a       個々の島の人口の配列
	 * @param from
	 * @param to
	 * @param average 平均人口
	 * @return aのfromからtoまで必要な橋の数
	 */
	private static int calcResult(final int[] a, int from, int to, final int average) {
		int sum = 0;
		for (int i = from; i <= to; i++) {
			sum += a[i];
			if ((i - from + 1) * average == sum) {
				// i番目の島までの人口の合計が平均値x島の数と等しい場合
				return (i - from) + calcResult(a, i + 1, to, average);
			}
		}
		return to - from + 1;
	}
}
