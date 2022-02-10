package abc.abc151_200.abc155;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			for (int ai : a) {
				if ((0 == (1 & ai)) && ((0 != ai % 3) && (0 != ai % 5))) {
					System.out.println("DENIED");
					return;
				}
			}
			System.out.println("APPROVED");
		}
	}
}
