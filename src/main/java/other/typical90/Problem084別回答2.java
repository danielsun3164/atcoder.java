package other.typical90;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://github.com/E869120/kyopro_educational_90/blob/main/sol/084-02.cpp をもとに作成
 */
public class Problem084別回答2 {

	/** oを表す文字 */
	private static final char O = 'o';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			char[] s = scanner.next().toCharArray();
			int[] a = new int[n + 1], b = new int[n + 1];
			a[0] = b[0] = 0;
			IntStream.range(0, n).forEach(i -> {
				if (O == s[i]) {
					a[i + 1] = i + 1;
					b[i + 1] = b[i];
				} else {
					a[i + 1] = a[i];
					b[i + 1] = i + 1;
				}
			});
			System.out.println(IntStream.rangeClosed(1, n).mapToLong(i -> Math.min(a[i], b[i])).sum());
		}
	}
}
