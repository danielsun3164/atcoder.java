package abc.abc151_200.abc160;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemE別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int x = scanner.nextInt(), y = scanner.nextInt();
			int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt();
			List<Integer> list = new ArrayList<>();
			// 赤色のりんごをx個のみ
			IntStream.range(0, a).map(i -> scanner.nextInt()).sorted().skip(a - x).boxed().forEach(list::add);
			// 緑色のりんごをy個のみ
			IntStream.range(0, b).map(i -> scanner.nextInt()).sorted().skip(b - y).boxed().forEach(list::add);
			// 無色のりんごをmin(c, x+y)個のみ
			IntStream.range(0, c).map(i -> scanner.nextInt()).sorted().skip(c - Math.min(c, x + y)).boxed()
					.forEach(list::add);
			list.sort(Comparator.reverseOrder());
			System.out.println(list.stream().limit(x + y).mapToLong(Integer::longValue).sum());
		}
	}
}
