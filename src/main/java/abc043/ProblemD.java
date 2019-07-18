package abc043;

import java.util.Scanner;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String s = scanner.nextLine();
			char pre2 = s.charAt(0);
			char pre1 = s.charAt(1);
			int start = -1, end = -1;
			if (pre2 == pre1) {
				start = 1;
				end = 2;
			} else {
				for (int i = 2; i < s.length(); i++) {
					char now = s.charAt(i);
					if (pre2 == now) {
						start = i - 1;
						end = i + 1;
						break;
					} else if (pre1 == now) {
						start = i;
						end = i + 1;
						break;
					}
					pre2 = pre1;
					pre1 = now;
				}
			}
			System.out.println(start + " " + end);
		}
	}
}
