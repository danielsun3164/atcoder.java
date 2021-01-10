package abc.abc151_200.abc188;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemF {

	/** 計算する目標 */
	private static long GOAL;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			GOAL = scanner.nextLong();
			long y = scanner.nextLong();
			System.out.println(solve(y, new HashMap<>()));
		}
	}

	/**
	 * yをGOALにするためのステップ数を計算する
	 * 
	 * @param y
	 * @param map 計算結果を保存するマップ
	 * @return yをGOALにするためのステップ数
	 */
	private static long solve(final long y, final Map<Long, Long> map) {
		if (GOAL >= y) {
			return GOAL - y;
		}
		if (map.containsKey(y)) {
			return map.get(y);
		}
		long result = Math.abs(GOAL - y);
		if (1 == (1 & y)) {
			result = min(result, solve((y + 1) >> 1, map) + 2, solve((y - 1) >> 1, map) + 2);
		} else {
			result = min(result, solve(y >> 1, map) + 1);
		}
		map.put(y, result);
		return result;
	}

	/**
	 * 入力配列の最小値を計算する
	 * 
	 * @param l
	 * @return 入力配列の最小値
	 */
	private static long min(long... l) {
		return Arrays.stream(l).min().getAsLong();
	}
}
