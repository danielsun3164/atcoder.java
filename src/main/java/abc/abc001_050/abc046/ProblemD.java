package abc.abc001_050.abc046;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通り実装したソースコード
 */
public class ProblemD {

	/** パーを表す文字 */
	private static final char PA = 'p';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			int p = (int) IntStream.range(0, s.length).filter(i -> PA == s[i]).count();
			System.out.println(s.length / 2 - p);
		}
	}
}
