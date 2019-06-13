package abc021;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemA {

	private static int[] ARRAY = { 8, 4, 2, 1 };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			List<Integer> list = new ArrayList<>();
			while (n > 0) {
				for (int integer : ARRAY) {
					if (n >= integer) {
						list.add(integer);
						n -= integer;
						break;
					}
				}
			}
			System.out.println(list.size());
			list.forEach(System.out::println);
		}
	}
}
