package abc.abc066;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			LinkedList<Integer> list = new LinkedList<>();
			IntStream.range(0, n).forEach(i -> {
				if (0 == (i & 1)) {
					// indexが偶数の場合、末尾に追加
					list.addLast(scanner.nextInt());
				} else {
					list.addFirst(scanner.nextInt());
				}
			});
			Iterator<Integer> iterator = (0 == (n & 1)) ? list.iterator() : list.descendingIterator();
			while (iterator.hasNext()) {
				System.out.print(iterator.next());
				System.out.print(iterator.hasNext() ? " " : "\n");
			}
		}
	}
}
