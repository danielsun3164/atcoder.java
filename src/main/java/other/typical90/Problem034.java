package other.typical90;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem034 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			Map<Integer, Integer> map = new HashMap<>();
			int start = 0, end = 0;
			while ((map.size() < k) && (end < n)) {
				map.put(a[end], map.getOrDefault(a[end], 0) + 1);
				end++;
			}
			int answer = end - start;
			while (end < n) {
				map.put(a[end], map.getOrDefault(a[end], 0) + 1);
				end++;
				while (map.size() > k) {
					int value = map.get(a[start]);
					if (1 == value) {
						map.remove(a[start]);
					} else {
						map.put(a[start], value - 1);
					}
					start++;
				}
				answer = Math.max(answer, end - start);
			}
			System.out.println(answer);
		}
	}
}
