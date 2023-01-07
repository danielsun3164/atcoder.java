package other.typical90;

import java.util.Scanner;

public class Problem067 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String n = scanner.next();
			int k = scanner.nextInt();
			while (k-- > 0) {
				n = process(n);
			}
			System.out.println(n);
		}
	}

	/**
	 * 入力8進数の数字の文字列を9進数へ変換し、「8」の桁を「5」に変更する
	 *
	 * @param n 入力8進数の数字の文字列
	 * @return 処理結果
	 */
	private static String process(String n) {
		long l = Long.parseLong(n, 8);
		n = Long.toString(l, 9);
		n = n.replaceAll("8", "5");
		return n;
	}
}
