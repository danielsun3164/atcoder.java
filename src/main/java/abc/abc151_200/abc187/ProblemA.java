package abc.abc151_200.abc187;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt();
			System.out.println(Math.max(s(a), s(b)));
		}
	}

	/**
	 * nを十進法で表したときの各桁の和を計算する
	 * 
	 * @param n
	 * @return nを十進法で表したときの各桁の和
	 */
	private static int s(int n) {
		int result = 0;
		while (n > 0) {
			result += n % 10;
			n /= 10;
		}
		return result;
	}
}
