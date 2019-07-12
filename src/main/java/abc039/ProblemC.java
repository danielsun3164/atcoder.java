package abc039;

import java.util.Scanner;

public class ProblemC {

	/** ピアノのキーの配列に対応する音 */
	private static final String[] RESULT = new String[] { "Do", "Do", "Re", "Re", "Mi", "Fa", "Fa", "So", "So", "La",
			"La", "Si" };

	/** ピアノのキーの配置 */
	private static final String PIANO = "WBWBWWBWBWBWWBWBWWBWBWBWWBWBWWBWBWBW";

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String s = scanner.nextLine();
			System.out.println(RESULT[PIANO.indexOf(s)]);
		}
	}
}
