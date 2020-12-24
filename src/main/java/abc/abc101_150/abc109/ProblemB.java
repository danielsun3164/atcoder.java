package abc.abc101_150.abc109;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			String prev = null;
			boolean shiritori = true;
			Set<String> set = new HashSet<>();
			for (int i = 0; i < n; i++) {
				String w = scanner.next();
				if (shiritori) {
					if (null != prev) {
						if (prev.charAt(prev.length() - 1) != w.charAt(0)) {
							shiritori = false;
						}
					}
				}
				set.add(w);
				prev = w;
			}
			System.out.println((shiritori && (set.size() == n)) ? "Yes" : "No");
		}
	}
}
