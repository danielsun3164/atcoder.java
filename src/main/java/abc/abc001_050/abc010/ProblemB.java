package abc.abc001_050.abc010;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	/** 花びらの数に対して、毟る必要のある枚数のマップ */
	private static final Map<Integer, Integer> map = new HashMap<>();
	static {
		map.put(1, 0);
		map.put(2, 1);
		map.put(3, 0);
		map.put(4, 1);
		map.put(5, 2);
		map.put(6, 3);
		map.put(7, 0);
		map.put(8, 1);
		map.put(9, 0);
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println(IntStream.range(0, n).map(i -> map.get(scanner.nextInt())).sum());
		}
	}
}
