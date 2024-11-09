package abc.abc201_250.abc236;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
			char t = s[a];
			s[a] = s[b];
			s[b] = t;
			System.out.println(s);
		}
	}
}
