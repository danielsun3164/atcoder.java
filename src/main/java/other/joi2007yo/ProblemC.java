package other.joi2007yo;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			IntStream.range(0, s.length).forEach(i -> s[i] = convert(s[i]));
			System.out.println(s);
		}
	}

	/**
	 * 変換後の文字cを変換前の文字に戻す
	 * 
	 * @param c 変換後の文字
	 * @return 変換前の文字
	 */
	private static char convert(char c) {
		if (c >= 'D') {
			return (char) (c - 3);
		}
		return (char) (c + 26 - 3);
	}
}
