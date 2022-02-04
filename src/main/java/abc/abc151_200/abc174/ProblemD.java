package abc.abc151_200.abc174;

import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			char[] c = scanner.next().toCharArray();
			NavigableSet<Integer> redSet = new TreeSet<>(), whiteSet = new TreeSet<>();
			IntStream.range(0, n).forEach(i -> {
				if ('R' == c[i]) {
					redSet.add(i);
				} else {
					whiteSet.add(i);
				}
			});
			if ((0 == redSet.size()) || (0 == whiteSet.size())) {
				System.out.println(0);
				return;
			}
			int count = 0;
			while (redSet.last() > whiteSet.first()) {
				int red = redSet.last(), white = whiteSet.first();
				redSet.remove(red);
				redSet.add(white);
				whiteSet.remove(white);
				whiteSet.add(red);
				count++;
			}
			System.out.println(count);
		}
	}
}
