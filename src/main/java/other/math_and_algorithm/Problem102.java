package other.math_and_algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class Problem102 {

	/** 3 */
	private static final int N = 3;
	/** BWR */
	private static final char[] BWR = "BWR".toCharArray();
	/** BWRを数字へ変換するマップ */
	private static final Map<Character, Integer> MAP = new HashMap<>();
	static {
		for (int i = 0; i < N; i++) {
			MAP.put(BWR[i], i);
		}
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			char[] c = scanner.next().toCharArray();
			int answer = IntStream.range(0, n).map(i -> MAP.get(c[i]) * combination(n - 1, i)).reduce(0,
					(s, ai) -> (s + ai) % N);
			if (0 == (1 & n)) {
				// 答えを (-1)^(N-1) で掛ける
				answer = (N - answer) % N;
			}
			System.out.println(BWR[answer]);
		}
	}

	/**
	 * リュカの定理で n_C_r mod 3 を計算する
	 *
	 * @param n
	 * @param r
	 * @return n_C_r mod 3
	 */
	private static int combination(int n, int r) {
		if ((n < N) && (r < N)) {
			return (n < r) ? 0 : ((2 == n) && (1 == r) ? 2 : 1);
		}
		return combination(n / N, r / N) * combination(n % N, r % N) % N;
	}
}
