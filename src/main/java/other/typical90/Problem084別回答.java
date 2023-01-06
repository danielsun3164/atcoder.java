package other.typical90;

import java.util.Scanner;

/**
 * 解説通りに実装したソースコード
 *
 * https://github.com/E869120/kyopro_educational_90/blob/main/sol/084-01.cpp をもとに作成
 */
public class Problem084別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			char[] s = scanner.next().toCharArray();
			long answer = n * (long) (n + 1) / 2L, count = 0L;
			for (int i = 0; i < n; i++) {
				count++;
				if ((n - 1 == i) || (s[i] != s[i + 1])) {
					answer -= count * (count + 1) / 2L;
					count = 0L;
				}
			}
			System.out.println(answer);
		}
	}
}
