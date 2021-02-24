package other.joisc2007;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://atcoder.jp/contests/joisc2007/submissions/7665851 を参考に作成
 */
public class ProblemB_Factorial {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int max = 1;
			Map<Integer, Integer> primeFactors = getPrimeFactors(n);
			for (Map.Entry<Integer, Integer> entry : primeFactors.entrySet()) {
				int count = entry.getValue(), m = 0, t = 0, k = entry.getKey();
				while (count > 0) {
					m += k;
					t = m;
					while (0 == t % k) {
						count--;
						t /= k;
					}
				}
				max = Math.max(max, m);
			}
			System.out.println(max);
		}
	}

	/**
	 * nの素数の約数それぞれの個数を計算する
	 * 
	 * @param n
	 * @return マップ、キーは素数、値は個数
	 */
	private static Map<Integer, Integer> getPrimeFactors(int n) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 2; i * i <= n; i++) {
			while (0 == n % i) {
				n /= i;
				map.put(i, map.getOrDefault(i, 0) + 1);
			}
		}
		if (n > 1) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		return map;
	}
}
