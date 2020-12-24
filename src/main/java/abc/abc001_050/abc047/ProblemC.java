package abc.abc001_050.abc047;

import java.util.Scanner;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			char pre = ' ';
			int count = 0;
			for (char c : s) {
				if (c != pre) {
					count++;
					pre = c;
				}
			}
			System.out.println(count - 1);
		}
	}
}
