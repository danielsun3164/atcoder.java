package abc.abc001_050.abc019;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Set<Integer> set = new HashSet<>();
			IntStream.range(0, n).forEach(i -> {
				int ai = scanner.nextInt();
				// すべての数字を2で繰り返して割って、奇数になってからsetに追加
				while (0 == (ai & 1)) {
					ai >>= 1;
				}
				set.add(ai);
			});
			System.out.println(set.size());
		}
	}
}
