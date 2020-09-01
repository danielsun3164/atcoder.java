package abc.abc053;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = new int[n];
			Map<Integer, Integer> map = new HashMap<>();
			IntStream.range(0, n).forEach(i -> {
				a[i] = scanner.nextInt();
				map.put(a[i], map.getOrDefault(a[i], 0) + 1);
			});
			int remain = map.size();
			// 解説通りに結果の計算方法を変更
			System.out.println(remain - ((remain & 1) ^ 1));
		}
	}
}
