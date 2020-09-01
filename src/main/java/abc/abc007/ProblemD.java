package abc.abc007;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProblemD {

	/** 10進数を8進数に変換するためのマップ */
	private static final Map<Character, Character> MAP = new HashMap<>();
	static {
		MAP.put('0', '0');
		MAP.put('1', '1');
		MAP.put('2', '2');
		MAP.put('3', '3');
		MAP.put('5', '4');
		MAP.put('6', '5');
		MAP.put('7', '6');
		MAP.put('8', '7');
	}

	private static final char DEFAULT_CHAR = '7';

	/** 禁止文字の変換マップ */
	private static final Map<Character, Character> INVALID_CONVERT_MAP = new HashMap<>();
	static {
		INVALID_CONVERT_MAP.put('4', '3');
		INVALID_CONVERT_MAP.put('9', '7');
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long a = scanner.nextLong();
			long b = scanner.nextLong();
			System.out.println(calcResult(b) - calcResult(a - 1));
		}
	}

	/**
	 * @param input
	 * @return 1〜inputまでの禁止文字を含む数字の数
	 */
	private static long calcResult(long input) {
		StringBuilder sb = new StringBuilder();
		boolean hasInvalidChar = false;
		for (char c : String.valueOf(input).toCharArray()) {
			// 前に禁止文字がある場合
			if (hasInvalidChar) {
				sb.append(DEFAULT_CHAR);
			} else {
				if (INVALID_CONVERT_MAP.keySet().contains(c)) {
					sb.append(INVALID_CONVERT_MAP.get(c));
					hasInvalidChar = true;
				} else {
					sb.append(MAP.get(c));
				}
			}
		}
		// 8進数を計算
		long oct = Long.parseLong(sb.toString(), 8);
		return input - oct;
	}
}
