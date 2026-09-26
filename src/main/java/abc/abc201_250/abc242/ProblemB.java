package abc.abc201_250.abc242;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			Arrays.sort(s);
			System.out.println(s);
		}
	}
}
