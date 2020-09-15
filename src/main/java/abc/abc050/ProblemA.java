package abc.abc050;

import java.util.Scanner;

import javax.script.ScriptException;

public class ProblemA {

	public static void main(String[] args) throws ScriptException {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt();
			String op = scanner.next();
			int b = scanner.nextInt();
			System.out.println("+".equals(op) ? a + b : a - b);
		}
	}
}
