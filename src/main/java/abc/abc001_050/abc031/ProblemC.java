package abc.abc001_050.abc031;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			System.out.println(getResult(a, 0, 0, 0));
		}
	}

	/**
	 * @param a      数列
	 * @param person 0:高橋くん、1:青木くん
	 * @param start  選んだ結果の中で小さいほう
	 * @param end    選んだ結果の中で大きいほう
	 * @return 高橋くんが得られる最大点数
	 */
	private static int getResult(final int[] a, int person, int start, int end) {
		if (0 == person) {
			// 高橋くんの処理
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < a.length; i++) {
				max = Math.max(max, getResult(a, person + 1, i, 0));
			}
			return max;
		} else {
			// 青木くんの処理
			int max = Integer.MIN_VALUE;
			int selection = 0;
			for (int i = 0; i < a.length; i++) {
				if (i != start) {
					int aokiResult = calcResult(a, Math.min(start, i), Math.max(start, i), person);
					if (aokiResult > max) {
						max = aokiResult;
						selection = i;
					}
				}
			}
			return calcResult(a, Math.min(start, selection), Math.max(start, selection), person - 1);
		}
	}

	/**
	 * @param a      数列
	 * @param start  選んだ結果の中で小さいほう
	 * @param end    選んだ結果の中で大きいほう
	 * @param person 0:高橋くん、1:青木くん
	 * @return personが得られる点数
	 */
	private static int calcResult(int[] a, int start, int end, int person) {
		return IntStream.rangeClosed(0, end - start).filter(i -> person == (i & 1)).map(i -> a[i + start]).sum();
	}
}
