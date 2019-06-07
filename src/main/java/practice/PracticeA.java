package practice;

import java.util.Scanner;

public class PracticeA {

	/**
	 * get input like
	 * 
	 * <pre>
	 * number1(return)
	 * number2(space)number3(return)
	 * string(return)
	 * </pre>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int number1 = scanner.nextInt();
			String string = scanner.nextLine();
			int number2 = scanner.nextInt();
			int number3 = scanner.nextInt();
			string = scanner.nextLine();
			string = scanner.nextLine();
			System.out.println((number1 + number2 + number3) + " " + string);
		}
	}
}
