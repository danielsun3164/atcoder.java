package abc.abc151_200.abc166;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.LongStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long x = scanner.nextLong();
			long[] array = LongStream.range(0, 200).map(i -> i * i * i * i * i).toArray();
			for (int i = 0; i < 200; i++) {
				int a;
				if ((a = Arrays.binarySearch(array, x + array[i])) >= 0) {
					System.out.println(a + " " + i);
					break;
				} else if ((a = Arrays.binarySearch(array, x - array[i])) >= 0) {
					System.out.println(a + " -" + i);
					break;
				}
			}
		}
	}
}
