package other.joisc2007;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemA_Score {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = new int[n], s = new int[n];
			IntStream.range(0, n).forEach(i -> a[i] = s[i] = scanner.nextInt());
			Arrays.sort(s);
			Map<Integer, Integer> map = new HashMap<>();
			IntStream.range(0, n).forEach(i -> map.put(s[i], n - i));
			IntStream.range(0, n).forEach(i -> System.out.println(map.get(a[i])));
		}
	}
}
