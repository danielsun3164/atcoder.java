package apg4b;

import java.util.Scanner;

public class ProblemEX12 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.nextLine().toCharArray();
			char prev = '+';
			int number = 0;
			for (char c : s) {
				if ((c >= '0') && (c <= '9')) {
					switch (prev) {
					case '+':
						number += c - '0';
						break;
					case '-':
					default:
						number -= c - '0';
						break;
					}
				} else {
					prev = c;
				}
			}
			System.out.println(number);
		}
	}
}
