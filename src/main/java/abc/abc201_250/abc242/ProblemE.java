package abc.abc201_250.abc242;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemE {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;
	/** 英文字の数 */
	private static final long N = 26;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			// TLE対策のため、結果をStringBuilderにまとめる
			StringBuilder sb = new StringBuilder();
			while (t-- > 0) {
				int n = scanner.nextInt();
				char[] s = scanner.next().toCharArray();
				char[] target = s.clone();
				IntStream.range(0, n / 2).forEach(i -> target[n - 1 - i] = target[i]);
				long answer = 0L;
				for (int i = 0; i < (n + 1) / 2; i++) {
					answer = (answer * N + (s[i] - 'A')) % MOD;
				}
				if (Arrays.compare(s, target) >= 0) {
					answer = (answer + 1L) % MOD;
				}
				sb.append(answer).append(System.lineSeparator());
			}
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
