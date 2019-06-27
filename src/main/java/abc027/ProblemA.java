package abc027;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemA {

	private static final int SIZE = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			List<Integer> list = new ArrayList<>();
			IntStream.range(0, SIZE).forEach(i -> {
				int l = scanner.nextInt();
				if (!list.contains(l)) {
					list.add(l);
				} else {
					list.remove(Integer.valueOf(l));
				}
			});
			System.out.println(list.get(0));
		}
	}
}
