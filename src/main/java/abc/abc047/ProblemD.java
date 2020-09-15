package abc.abc047;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			// t
			scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			// max[i] はa[i]〜a[n-1]の最大値
			int[] max = new int[n];
			max[n - 1] = a[n - 1];
			IntStream.range(1, n).map(i -> n - 1 - i).forEach(i -> max[i] = Math.max(max[i + 1], a[i]));
			Map<Integer, Integer> map = new HashMap<>();
			int maxResult = IntStream.range(0, n).map(i -> {
				int result = max[i] - a[i];
				map.put(result, map.getOrDefault(result, 0) + 1);
				return result;
			}).max().getAsInt();
			System.out.println(map.get(maxResult));
		}
	}
}
