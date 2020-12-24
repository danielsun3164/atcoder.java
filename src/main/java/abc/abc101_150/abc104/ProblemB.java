package abc.abc101_150.abc104;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			boolean result = true;
			if ('A' != s[0]) {
				// 最初の文字が'A'でない
				result = false;
			} else if (1 != IntStream.rangeClosed(2, s.length - 2).filter(i -> 'C' == s[i]).count()) {
				// 3文字目から最後から2文字まで'C'の数が1でない
				result = false;
			} else if (2 != IntStream.range(0, s.length).filter(i -> ('A' <= s[i]) && (s[i] <= 'Z')).count()) {
				// 最初の'A'と'C'以外はすべて小文字でない
				result = false;
			}
			System.out.println(result ? "AC" : "WA");
		}
	}
}
