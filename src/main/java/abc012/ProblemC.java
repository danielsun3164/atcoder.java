package abc012;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	private static final String MULTIPLY = " x ";

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			// 計算結果から計算式を取得するマップ
			Map<Integer, List<String>> map = new HashMap<>();
			IntStream.rangeClosed(1, 9).forEach(i -> IntStream.rangeClosed(1, 9).forEach(j -> {
				int product = i * j;
				List<String> list = map.get(product);
				if (null == list) {
					list = new ArrayList<>();
					map.put(product, list);
				}
				list.add(i + MULTIPLY + j);
			}));
			// 九九すべての結果の合計
			int sum = IntStream.rangeClosed(1, 9).map(i -> IntStream.rangeClosed(1, 9).map(j -> i * j).sum()).sum();
			map.get(sum - n).forEach(System.out::println);
		}
	}
}
