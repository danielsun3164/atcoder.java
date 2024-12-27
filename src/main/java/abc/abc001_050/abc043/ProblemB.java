package abc.abc001_050.abc043;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String s = scanner.next();
			StringBuilder sb = new StringBuilder();
			s.chars().forEach(c -> {
				switch (c) {
				case '0', '1' -> sb.append((char) c);
				default -> {
					if (sb.length() > 0) {
						sb.deleteCharAt(sb.length() - 1);
					}
				}
				}
			});
			System.out.println(sb.toString());
		}
	}
}
