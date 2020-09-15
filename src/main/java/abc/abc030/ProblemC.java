package abc.abc030;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int x = scanner.nextInt(), y = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int[] b = IntStream.range(0, m).map(i -> scanner.nextInt()).toArray();
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
