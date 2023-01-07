package other.typical90;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class Problem006別回答 {

	/** 文字の種類数 */
	private static final int N = 26;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			char[] s = scanner.next().toCharArray();
			int[][] nex = new int[n + 1][N];
			Arrays.fill(nex[n], n);
			IntStream.range(0, n).map(i -> n - 1 - i).forEach(
					i -> IntStream.range(0, N).forEach(j -> nex[i][j] = ((s[i] - 'a') == j) ? i : nex[i + 1][j]));
			StringBuilder sb = new StringBuilder();
			int pos = 0;
			for (int i = 0; i < k; i++) {
				for (int j = 0; j < N; j++) {
					int nexPos = nex[pos][j];
					if (nexPos <= ((n - k) + i)) {
						sb.append((char) (j + 'a'));
						pos = nexPos + 1;
						break;
					}
				}
			}
			System.out.println(sb.toString());
		}
	}
}
