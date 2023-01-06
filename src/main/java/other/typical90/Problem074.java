package other.typical90;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class Problem074 {

	/** aを表す文字 */
	private static final char A = 'a';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			char[] s = scanner.next().toCharArray();
			long[] d = IntStream.range(0, n).mapToLong(i -> s[i] - A).toArray();
			System.out.println(IntStream.range(0, n).mapToLong(i -> d[i] << i).sum());
		}
	}
}
