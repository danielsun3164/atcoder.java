package abc.abc201_250.abc247;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			String[] s = new String[n], t = new String[n];
			Map<String, Integer> count = new HashMap<>();
			IntStream.range(0, n).forEach(i -> {
				s[i] = scanner.next();
				t[i] = scanner.next();
				count.put(s[i], count.getOrDefault(s[i], 0) + 1);
				count.put(t[i], count.getOrDefault(t[i], 0) + 1);
			});
			for (int i = 0; i < n; i++) {
				// 姓と名が同じ場合の対応
				if (Objects.equals(s[i], t[i]) && (2 == count.get(s[i]))) {
					continue;
				}
				if ((count.get(s[i]) > 1) && (count.get(t[i]) > 1)) {
					System.out.println("No");
					return;
				}
			}
			System.out.println("Yes");
		}
	}
}
