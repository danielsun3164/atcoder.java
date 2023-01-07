package other.typical90;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem044 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), q = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			// インデックスのずれる数
			int k = 0;
			// TLE対策のため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			while (q-- > 0) {
				int t = scanner.nextInt(), x = scanner.nextInt() - 1, y = scanner.nextInt() - 1;
				if (1 == t) {
					int from = (x + n - k) % n, to = (y + n - k) % n;
					int temp = a[from];
					a[from] = a[to];
					a[to] = temp;
				} else if (2 == t) {
					k = (k + 1) % n;
				} else {
					sb.append(a[(x + n - k) % n]).append(System.lineSeparator());
				}
			}
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
