package abc.abc005;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			int n = scanner.nextInt();
			int[] a = new int[n];
			IntStream.range(0, n).forEach(i -> a[i] = scanner.nextInt());
			int m = scanner.nextInt();
			int[] b = new int[m];
			IntStream.range(0, m).forEach(i -> b[i] = scanner.nextInt());
			boolean result = true;
			if (n >= m) {
				int next = 0;
				for (int i = 0; i < m; i++) {
					next = getNext(b[i], next, a, t);
					if (next < 0) {
						result = false;
						break;
					}
					next++;
				}
			} else {
				result = false;
			}
			System.out.println(result ? "yes" : "no");
		}
	}

	/**
	 * @param custom 顧客が来る時間
	 * @param start  たこ焼きの検索開始index
	 * @param a      たこ焼きの焼き上がり時間一覧
	 * @param t      たこ焼きの販売時間
	 * @return たこ焼きの焼き上がり時間一覧におけるindex，見つからない場合は-1
	 */
	private static int getNext(int custom, int start, int[] a, final int t) {
		int result = -1;
		for (int i = start; i < a.length; i++) {
			if ((custom >= a[i]) && (custom <= a[i] + t)) {
				result = i;
				break;
			}
		}
		return result;
	}
}
