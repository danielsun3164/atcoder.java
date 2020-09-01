package abc.abc177;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray(), t = scanner.next().toCharArray();
			System.out.println(t.length
					- IntStream.rangeClosed(0, s.length - t.length).map(i -> calcResult(i, s, t)).max().getAsInt());
		}
	}

	/**
	 * sのfromからの部分文字列とtと同じ文字の数を計算
	 * 
	 * @param from
	 * @param s
	 * @param t
	 * @return sのfromからの部分文字列とtと同じ文字の数
	 */
	private static int calcResult(int from, char[] s, char[] t) {
		int result = 0;
		for (int i = 0; i < t.length; i++) {
			result += (s[from + i] == t[i]) ? 1 : 0;
		}
		return result;
	}
}
