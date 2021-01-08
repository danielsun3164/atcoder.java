package abc.abc001_050.abc033;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String s = scanner.next();
			System.out.println(Arrays.stream(s.split("\\+")).filter(string -> !string.contains("0")).count());
		}
	}
}
