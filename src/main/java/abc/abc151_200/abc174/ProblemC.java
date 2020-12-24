package abc.abc151_200.abc174;

import java.util.Scanner;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int k = scanner.nextInt();
			if ((0 == (k % 2)) || (0 == (k % 5))) {
				System.out.println(-1);
				return;
			}
			System.out.println(getResult(k));
		}
	}

	/**
	 * 7,77,777,… という数列の中に初めてkの倍数が登場するのは何項目を計算する
	 * 
	 * @param k k
	 * @return 7,77,777,… という数列の中に初めてkの倍数が登場するのは何項目
	 */
	private static int getResult(int k) {
		if (0 == (k % 7)) {
			k /= 7;
		}
		long now = 1L;
		for (int i = 1;; i++) {
			if (0 == (now % k)) {
				return i;
			}
			now = (now * 10 + 1) % k;
		}
	}
}
