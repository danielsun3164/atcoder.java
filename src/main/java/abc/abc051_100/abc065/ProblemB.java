package abc.abc051_100.abc065;

import java.util.BitSet;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	/** 終了となるボタン */
	private static final int STOP_BUTTON = 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = new int[n];
			int count = (int) IntStream.range(0, n).map(i -> a[i] = scanner.nextInt() - 1).filter(i -> i == STOP_BUTTON)
					.count();
			if (count == 0) {
				// 終了するボタンに通じるボタンがない場合
				System.out.println(-1);
				return;
			}
			int now = 0, result = 0;
			// 押したことのあるボタンを表す
			BitSet visited = new BitSet(n);
			visited.set(now, true);
			while (true) {
				result++;
				if (visited.get(a[now])) {
					result = -1;
					break;
				} else {
					if (a[now] == STOP_BUTTON) {
						break;
					}
					visited.set(a[now], true);
					now = a[now];
				}
			}
			System.out.println(result);
		}
	}
}
