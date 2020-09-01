package abc.abc030;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			int[] a = new int[n];
			IntStream.range(0, n).forEach(i -> a[i] = scanner.nextInt());
			int[] b = new int[m];
			IntStream.range(0, m).forEach(i -> b[i] = scanner.nextInt());
			int aCounter = 0, bCounter = 0;
			// 往復した回数
			int count = 0;
			// 現在の時刻
			int now = 0;
			while (true) {
				while ((aCounter < a.length) && (now > a[aCounter])) {
					aCounter++;
				}
				if (aCounter >= a.length) {
					break;
				}
				now = a[aCounter] + x;
				while ((bCounter < b.length) && (now > b[bCounter])) {
					bCounter++;
				}
				if (bCounter >= b.length) {
					break;
				}
				now = b[bCounter] + y;
				count++;
			}
			System.out.println(count);
		}
	}
}
