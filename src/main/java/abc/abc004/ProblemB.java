package abc.abc004;

import java.util.Scanner;
import java.util.Stack;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			Stack<String> stack = new Stack<>();
			IntStream.range(0, 4).forEach(i -> stack.push(new StringBuilder(scanner.nextLine()).reverse().toString()));
			while (!stack.empty()) {
				System.out.println(stack.pop());
			}
		}
	}
}
