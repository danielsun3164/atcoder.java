package abc.abc051_100.abc084;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] c = new int[n], s = new int[n], f = new int[n];
			IntStream.range(0, n - 1).forEach(i -> {
				c[i] = scanner.nextInt();
				s[i] = scanner.nextInt();
				f[i] = scanner.nextInt();
			});
			IntStream.range(0, n).map(i -> getResult(i, n, 0, c, s, f)).forEach(System.out::println);
		}
	}

	/**
	 * index番目の駅から出発するときの終点までの運行開始からの所要時間を計算
	 * 
	 * @param index     出発駅
	 * @param n         駅の総数
	 * @param startTime 出発時間
	 * @param c
	 * @param s
	 * @param f
	 * @return index番目の駅から出発するときの終点までの運行開始からの所要時間
	 */
	private static int getResult(int index, int n, int startTime, final int[] c, final int[] s, final int[] f) {
		if (index >= n - 1) {
			return startTime;
		}
		return getResult(index + 1, n, Math.max((startTime + f[index] - 1) / f[index] * f[index], s[index]) + c[index],
				c, s, f);
	}
}
