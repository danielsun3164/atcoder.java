package abc103;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			char[] t = scanner.next().toCharArray();
			boolean result = false;
			for (int i = 0; i < s.length; i++) {
				int count = 0;
				while ((count < s.length) && (s[(i + count) % s.length] == t[count])) {
					count++;
				}
				if (s.length == count) {
					result = true;
					break;
				}
			}
			System.out.println(result ? "Yes" : "No");
		}
	}
}
