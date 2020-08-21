package abc101;

import java.util.Scanner;

public class ProblemB {

	/** 10 */
	private static final int TEN = 10;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println((0 == n % s(n)) ? "Yes" : "No");
		}
	}

	/**
	 * 整数nに対して、nを十進法で表したときの各桁の和
	 * 
	 * @param n 整数n
	 * @return nを十進法で表したときの各桁の和
	 */
	private static int s(int n) {
		int answer = 0;
		while (n > 0) {
			answer += n % TEN;
			n /= TEN;
		}
		return answer;
	}
}
