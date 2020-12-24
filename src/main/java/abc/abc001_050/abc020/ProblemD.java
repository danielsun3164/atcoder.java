package abc.abc001_050.abc020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * https://atcoder.jp/contests/abc020/submissions/1798277 を元に作成
 */
public class ProblemD {

	private static final int MOD = 1_000_000_007;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			// kの約数を求める
			List<Integer> divList = new ArrayList<>();
			int sqrtK = (int) Math.sqrt(k);
			IntStream.rangeClosed(1, sqrtK).filter(i -> 0 == (k % i)).forEach(i -> {
				divList.add(i);
				if (i != k / i) {
					divList.add(k / i);
				}
			});
			Collections.sort(divList);

			long answer = 0;
			long sum[] = new long[divList.size()];
			for (int i = divList.size() - 1; i >= 0; i--) {
				int div = divList.get(i);
				// 1〜nの範囲で最大のdivの倍数
				int divMax = n / div * div;
				sum[i] = (long) (div + divMax) * (divMax / div) / 2;
				// 今まで取り出した約数の中でdivの倍数であるのもののsumを全部引く
				for (int j = i + 1; j < divList.size(); j++) {
					if (divList.get(j) % div == 0) {
						sum[i] -= sum[j];
					}
				}
				answer = (answer + sum[i] / div) % MOD;
			}
			answer = (answer * k) % MOD;
			System.out.println(answer);
		}
	}
}
