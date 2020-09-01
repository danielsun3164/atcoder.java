package other.past201912;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemH {

	/** 一つのカードを販売するコマンド */
	private static final int ONE_CARD = 1;
	/** 奇数番号のカードを販売するコマンド */
	private static final int ODD_CARDS = 2;
	/** すべてのカードを販売するコマンド */
	private static final int ALL_CARDS = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] c = new int[n];
			IntStream.range(0, n).forEach(i -> c[i] = scanner.nextInt());
			// すべてのカードの在庫最小値
			int allMin = Arrays.stream(c).min().getAsInt();
			// 番号が奇数のカードの在庫最小値
			int oddMin = IntStream.range(0, (n + 1) / 2).map(i -> c[i * 2]).min().getAsInt();
			// すべてのカードの販売数、奇数番号のカードの販売数
			int allCounter = 0, oddCounter = 0;
			long result = 0L;
			int q = scanner.nextInt();
			for (int i = 0; i < q; i++) {
				int s = scanner.nextInt();
				if (ONE_CARD == s) {
					int x = scanner.nextInt() - 1;
					int a = scanner.nextInt();
					int counter = allCounter + ((0 == (x & 1)) ? oddCounter : 0);
					if (c[x] >= counter + a) {
						c[x] -= a;
						result += a;
						int now = c[x] - counter;
						if ((0 == (x & 1)) && (now < oddMin)) {
							oddMin = now;
						}
						allMin = Math.min(now, allMin);
					}
				} else if (ODD_CARDS == s) {
					int a = scanner.nextInt();
					if (oddMin >= a) {
						oddMin -= a;
						oddCounter += a;
						allMin = Math.min(allMin, oddMin);
					}
				} else if (ALL_CARDS == s) {
					int a = scanner.nextInt();
					if (allMin >= a) {
						allMin -= a;
						oddMin -= a;
						allCounter += a;
					}
				}
			}
			System.out.println(result + ((long) allCounter) * n + ((long) oddCounter) * ((n + 1) / 2));
		}
	}
}
