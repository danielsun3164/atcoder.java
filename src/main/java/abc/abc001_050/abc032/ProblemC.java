package abc.abc001_050.abc032;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long k = scanner.nextLong();
			long[] s = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).toArray();
			if (Arrays.stream(s).filter(l -> 0L == l).count() > 0) {
				// 配列には0が含まれる
				System.out.println(n);
			} else {
				int start = 0, end = 0;
				long product = s[end];
				int max = 0;
				while (true) {
					if (product > k) {
						// 積がkを超えた場合
						product /= s[start++];
						if (start > end) {
							if (end < n - 1) {
								product *= s[++end];
							} else {
								break;
							}
						}
					} else {
						max = Math.max(max, end - start + 1);
						if (end < n - 1) {
							product *= s[++end];
						} else {
							break;
						}
					}
				}
				System.out.println(max);
			}
		}
	}
}
