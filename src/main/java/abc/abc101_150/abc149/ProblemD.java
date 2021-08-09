package abc.abc101_150.abc149;

import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	/** グーを表す文字 */
	private static final char ROCK = 'r';
	/** チョキを表す文字 */
	private static final char SCISSORS = 's';
	/** パーを表す文字 */
	private static final char PAPER = 'p';
	/** 任意の文字 */
	private static final char ANY = '*';
	/** 勝つ文字のマップ */
	private static final Map<Character, Character> MAP = Map.of(ROCK, PAPER, SCISSORS, ROCK, PAPER, SCISSORS);

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			int r = scanner.nextInt(), s = scanner.nextInt(), p = scanner.nextInt();
			char[] t = scanner.next().toCharArray(), w = new char[n];
			// 得点のマップ
			Map<Character, Integer> map = Map.of(ROCK, r, SCISSORS, s, PAPER, p, ANY, 0);
			System.out.println(IntStream.range(0, n).map(i -> {
				char now = MAP.get(t[i]);
				return map.get(w[i] = (i >= k) ? ((now == w[i - k]) ? ANY : now) : now);
			}).sum());
		}
	}
}
