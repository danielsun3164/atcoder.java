package abc.abc151_200.abc154;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			Arrays.fill(s, 'x');
			System.out.println(s);
		}
	}
}
