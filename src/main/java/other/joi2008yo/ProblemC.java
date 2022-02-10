package other.joi2008yo;

import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			NavigableSet<Integer> taroSet = new TreeSet<>(), hanakoSet = new TreeSet<>();
			IntStream.range(0, n).forEach(i -> taroSet.add(scanner.nextInt()));
			IntStream.rangeClosed(1, 2 * n).filter(i -> !taroSet.contains(i)).forEach(i -> hanakoSet.add(i));
			int now = 0;
			NavigableSet<Integer> nextSet = taroSet;
			while (!taroSet.isEmpty() && !hanakoSet.isEmpty()) {
				Integer higher = nextSet.higher(now);
				if (null != higher) {
					nextSet.remove(higher);
					now = higher;
				} else {
					now = 0;
				}
				nextSet = (nextSet == taroSet) ? hanakoSet : taroSet;
			}
			System.out.println(hanakoSet.size());
			System.out.println(taroSet.size());
		}
	}
}
