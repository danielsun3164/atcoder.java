package abc.abc019;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.nextLine().toCharArray();
			StringBuilder sb = new StringBuilder();
			char prev = ' ';
			int count = 0;
			for (char c : s) {
				if (c == prev) {
					count++;
				} else {
					if (count > 0) {
						sb.append(count);
					}
					sb.append(c);
					prev = c;
					count = 1;
				}
			}
			if (count > 0) {
				sb.append(count);
			}
			System.out.println(sb.toString());
		}
	}
}
