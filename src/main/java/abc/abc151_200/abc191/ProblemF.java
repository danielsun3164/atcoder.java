package abc.abc151_200.abc191;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = new int[n];
			int min = IntStream.range(0, n).map(i -> a[i] = scanner.nextInt()).min().getAsInt();
			Map<Integer, Integer> t = new HashMap<>();
			IntStream.range(0, n).forEach(i -> {
				for (int j = 1; (j * j <= a[i]) && (j <= min); j++) {
					if (0 == a[i] % j) {
						t.put(j, gcd(t.getOrDefault(j, a[i]), a[i]));
						int k = a[i] / j;
						if ((k <= min) && (k != j)) {
							t.put(k, gcd(t.getOrDefault(k, a[i]), a[i]));
						}
					}
				}
			});
			System.out.println(t.entrySet().stream().filter(entry -> entry.getKey().equals(entry.getValue())).count());
		}
	}

	/**
	 * aとbの最大公約数を計算する
	 * 
	 * @param a
	 * @param b
	 * @return aとbの最大公約数
	 */
	private static int gcd(int a, int b) {
		return (0 == b) ? a : gcd(b, a % b);
	}
}
