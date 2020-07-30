package abc171;

import java.util.Scanner;

public class ProblemC {

	/** 英文字のアルファベット */
	private static final char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz".toCharArray();

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			StringBuilder sb = new StringBuilder();
			while (n > 0) {
				sb.append(ALPHABET[(int) ((n - 1) % 26)]);
				n = (n - 1) / 26;
			}
			System.out.println(sb.reverse().toString());
		}
	}
}
