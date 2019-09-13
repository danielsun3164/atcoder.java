package practice;

import java.util.Scanner;

public class PracticeA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int c = scanner.nextInt();
			String s = scanner.next();
			System.out.println((a + b + c) + " " + s);
		}
	}
}
