package abc.abc201_250.abc202;

import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	/** 反転文字変換用マップ */
	private static final Map<Character, Character> DICT = Map.of('0', '0', '1', '1', '6', '9', '8', '8', '9', '6');

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			int n = s.length;
			char[] t = new char[n];
			IntStream.range(0, n).forEach(i -> t[n - 1 - i] = DICT.get(s[i]));
			System.out.println(t);
		}
	}
}
