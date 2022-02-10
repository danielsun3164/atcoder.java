package abc.abc051_100.abc097;

import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String s = scanner.next();
			int k = scanner.nextInt();
			NavigableSet<String> set = new TreeSet<>();
			int n = s.length();
			// sの長さk以下のsubstringをすべてsetに追加する
			IntStream.range(0, n).forEach(
					i -> IntStream.rangeClosed(i + 1, Math.min(i + k, n)).forEach(j -> set.add(s.substring(i, j))));
			String answer = "";
			for (int i = 0; i < k; i++) {
				answer = set.pollFirst();
			}
			System.out.println(answer);
		}
	}
}
