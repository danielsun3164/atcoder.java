package abc.abc166;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 * 
 * https://atcoder.jp/contests/abc166/submissions/14875943 にも参考
 */
public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = new int[n];
			// i+A_i の数を保存するマップ
			Map<Integer, Integer> map = new HashMap<>();
			IntStream.range(0, n).forEach(i -> map.merge(i + (a[i] = scanner.nextInt()), 1, Integer::sum));
			System.out.println(IntStream.range(0, n).mapToLong(i -> map.getOrDefault(i - a[i], 0)).sum());
		}
	}
}
