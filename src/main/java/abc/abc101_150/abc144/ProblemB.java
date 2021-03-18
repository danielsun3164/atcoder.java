package abc.abc101_150.abc144;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			// 九九の計算結果を保存するセット
			Set<Integer> set = IntStream.rangeClosed(1, 9).flatMap(i -> IntStream.rangeClosed(1, 9).map(j -> i * j))
					.boxed().collect(Collectors.toSet());
			int n = scanner.nextInt();
			System.out.println(set.contains(n) ? "Yes" : "No");
		}
	}
}
