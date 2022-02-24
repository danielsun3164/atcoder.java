package abc.abc151_200.abc161;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.LongStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			// 重複回避のため、Setを使用
			Set<Long> answer = new HashSet<>();
			// nが2の場合、n-1がanswerに入れない
			LongStream.rangeClosed(Math.max(2, n - 1), n).forEach(i -> answer.add(i));
			for (long k = 2; k * k <= n; k++) {
				// k^m * (k+1) == nの場合の判定
				long now = n;
				while (0 == (now % k)) {
					now /= k;
				}
				if (1 == now % k) {
					answer.add(k);
				}
				// kがn-1の約数の場合の判定
				if (0 == (n - 1) % k) {
					answer.add(k);
					answer.add((n - 1) / k);
				}
			}
			System.out.println(answer.size());
		}
	}
}
