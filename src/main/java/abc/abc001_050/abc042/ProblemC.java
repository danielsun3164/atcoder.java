package abc.abc001_050.abc042;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Set<Character> okSet = new HashSet<>();
			IntStream.range(0, 10).forEach(i -> okSet.add((char) ('0' + i)));
			int k = scanner.nextInt();
			IntStream.range(0, k).forEach(i -> okSet.remove(Character.valueOf((char) ('0' + scanner.nextInt()))));
			int result = 0;
			main: for (int i = n; i < 10 * n; i++) {
				char[] array = String.valueOf(i).toCharArray();
				for (char c : array) {
					if (!okSet.contains(c)) {
						continue main;
					}
				}
				result = i;
				break;
			}
			System.out.println(result);
		}
	}
}
