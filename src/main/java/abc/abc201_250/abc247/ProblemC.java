package abc.abc201_250.abc247;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProblemC {

	/** 計算結果を保存するマップ */
	private static final Map<Integer, String> MAP = new HashMap<>();
	static {
		MAP.put(1, "1");
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println(calc(n));
		}
	}

	/**
	 * S_n の文字列を計算する
	 *
	 * @param n
	 * @return S_n の文字列
	 */
	private static String calc(int n) {
		if (MAP.containsKey(n)) {
			return MAP.get(n);
		}
		String result = calc(n - 1) + " " + n + " " + calc(n - 1);
		MAP.put(n, result);
		return result;
	}
}
