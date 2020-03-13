package abc085;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String s = scanner.next();
			System.out.println(s.replaceAll("^2017", "2018"));
		}
	}
}
