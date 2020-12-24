package abc.abc151_200.abc171;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			// 個々の数字の出現回数を保存するマップ
			Map<Integer, Integer> map = new HashMap<>();
			long sum = IntStream.range(0, n).mapToLong(i -> {
				int a = scanner.nextInt();
				map.put(a, map.getOrDefault(a, 0) + 1);
				return a;
			}).sum();
			int q = scanner.nextInt();
			for (int i = 0; i < q; i++) {
				int b = scanner.nextInt(), c = scanner.nextInt();
				int count = map.getOrDefault(b, 0);
				if (count > 0) {
					map.remove(b);
					map.put(c, map.getOrDefault(c, 0) + count);
					sum = sum + (c - b) * (long) count;
				}
				System.out.println(sum);
			}
		}
	}
}
