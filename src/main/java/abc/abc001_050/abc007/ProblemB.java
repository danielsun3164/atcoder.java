package abc.abc001_050.abc007;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String a = scanner.next();
			if (a.length() > 1) {
				System.out.println(a.substring(0, a.length() - 1));
			} else {
				// aの長さが1の場合
				char c = a.charAt(0);
				System.out.println((c == 'a') ? "-1" : (char) (c - 1));
			}
		}
	}
}
