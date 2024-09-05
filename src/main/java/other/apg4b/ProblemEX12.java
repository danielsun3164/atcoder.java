package other.apg4b;

import java.util.Scanner;

public class ProblemEX12 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			char prev = '+';
			int number = 0;
			for (char c : s) {
				if ((c >= '0') && (c <= '9')) {
					switch (prev) {
					case '+' -> number += c - '0';
					case '-' -> number -= c - '0';
					}
				} else {
					prev = c;
				}
			}
			System.out.println(number);
		}
	}
}
