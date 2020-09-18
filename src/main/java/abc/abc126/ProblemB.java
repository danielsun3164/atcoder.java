package abc.abc126;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String s = scanner.next();
			int a = Integer.parseInt(s.substring(0, 2)), b = Integer.parseInt(s.substring(2));
			if (isMonth(a)) {
				if (isMonth(b)) {
					System.out.println("AMBIGUOUS");
				} else {
					System.out.println("MMYY");
				}
			} else {
				if (isMonth(b)) {
					System.out.println("YYMM");
				} else {
					System.out.println("NA");
				}
			}
		}
	}

	/**
	 * nが月の数になれるかを返す
	 * 
	 * @param n
	 * @return nが月の数になれるか
	 */
	private static boolean isMonth(int n) {
		return (n >= 1) && (n <= 12);
	}
}
