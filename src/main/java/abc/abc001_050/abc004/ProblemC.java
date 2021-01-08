package abc.abc001_050.abc004;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			char[] array = "123456".toCharArray();
			IntStream.range(0, n % 30).forEach(i -> swap(array, i % 5, i % 5 + 1));
			System.out.println(array);
		}
	}

	/**
	 * 配列arrayのi番目とj番目を交換する
	 * 
	 * @param i
	 * @param j
	 * @param array 配列
	 */
	private static void swap(char[] array, int i, int j) {
		char temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
