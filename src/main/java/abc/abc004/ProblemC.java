package abc.abc004;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			char[] array = "123456".toCharArray();
			IntStream.range(0, n % 30).forEach(i -> swap(i % 5, i % 5 + 1, array));
			System.out.println(array);
		}
	}

	private static void swap(int i, int j, char[] array) {
		char temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
