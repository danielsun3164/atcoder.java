package abc045;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProblemB {

	private static final char A = 'a';
	private static final char B = 'b';
	private static final char C = 'c';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			Map<Character, char[]> cardMap = new HashMap<>();
			Map<Character, Integer> indexMap = new HashMap<>();
			cardMap.put(A, scanner.next().toCharArray());
			cardMap.put(B, scanner.next().toCharArray());
			cardMap.put(C, scanner.next().toCharArray());
			indexMap.put(A, 0);
			indexMap.put(B, 0);
			indexMap.put(C, 0);
			System.out.println(play(A, cardMap, indexMap));
		}
	}

	/**
	 * @param now      現在プレーする人
	 * @param cardMap  カード情報のマップ
	 * @param indexMap 各自何枚目になったかのマップ
	 * @return ゲームの勝者（大文字）
	 */
	private static char play(char now, Map<Character, char[]> cardMap, Map<Character, Integer> indexMap) {
		char[] cards = cardMap.get(now);
		int index = indexMap.get(now);
		if (index >= cards.length) {
			return Character.toUpperCase(now);
		}
		char next = cards[index];
		indexMap.put(now, index + 1);
		return play(next, cardMap, indexMap);
	}
}
